package org.openjfx.interop.generator;

import org.openjfx.interop.NativeSignatureEntry;
import org.openjfx.interop.annotations.NativeHeader;
import org.openjfx.interop.annotations.NativeKindSet;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Entry point run post-compile (bound to Maven's {@code process-classes} phase, before
 * the native library compile step): walks a module's already-compiled {@code target/classes}
 * to find every {@code Kind}-implementing enum vetted via {@code @NativeKindSet} and
 * every {@code Signature} enum marked {@code @NativeHeader}, then generates each
 * header -- validating along the way that every {@code Kind} an entry references
 * actually came from a vetted class. Relies on those classes already being loadable
 * via the ambient classpath {@code exec:java} runs with (target/classes is on it by
 * the time this phase runs) -- no separate classloader is built, so the
 * {@code Kind}/{@code Signature} instances read back via reflection are the exact
 * same classes/instances the annotated code itself uses.
 */
public final class Main {

    private Main() {}

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.err.println("usage: Main <classes-dir> [<classes-dir> ...] <output-dir>");
            System.exit(2);
        }
        // Last argument is the output dir; every argument before it is a classes
        // dir to scan. More than one is needed because @NativeKindSet-annotated
        // Kind enums (e.g. PrimitiveKind, ReturnExchangeKind) can live in a dependency
        // module's own target/classes, not just the module currently being built.
        Path outputDir = Path.of(args[args.length - 1]);
        List<Path> classesDirs = new ArrayList<>();
        for (int i = 0; i < args.length - 1; i++) {
            classesDirs.add(Path.of(args[i]));
        }

        List<Class<?>> classes = new ArrayList<>();
        for (Path classesDir : classesDirs) {
            if (!Files.isDirectory(classesDir)) {
                continue;
            }
            try (Stream<Path> files = Files.walk(classesDir)) {
                files.filter(p -> p.toString().endsWith(".class"))
                        .map(p -> binaryName(classesDir, p))
                        .forEach(name -> load(name).ifPresent(classes::add));
            } catch (UncheckedIOException e) {
                throw e.getCause();
            }
        }

        Set<Class<?>> vettedKindClasses = new HashSet<>();
        for (Class<?> type : classes) {
            if (type.isAnnotationPresent(NativeKindSet.class)) {
                vettedKindClasses.add(type);
            }
        }

        for (Class<?> type : classes) {
            if (type.isAnnotationPresent(NativeHeader.class) && NativeSignatureEntry.class.isAssignableFrom(type)) {
                HeaderGenerator.generate(type, outputDir, vettedKindClasses);
            }
        }
    }

    private static String binaryName(Path classesDir, Path classFile) {
        String relative = classesDir.relativize(classFile).toString();
        String withoutExt = relative.substring(0, relative.length() - ".class".length());
        return withoutExt.replace('/', '.').replace('\\', '.');
    }

    private static java.util.Optional<Class<?>> load(String binaryName) {
        try {
            return java.util.Optional.of(Class.forName(binaryName, false, Main.class.getClassLoader()));
        } catch (ClassNotFoundException | NoClassDefFoundError e) {
            // Not resolvable from this classpath (e.g. a test-only or unrelated class) -- skip.
            return java.util.Optional.empty();
        }
    }
}

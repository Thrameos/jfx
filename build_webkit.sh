#!/usr/bin/env bash
# Reusable, timed WebKit build trigger -- for measuring incremental-build cycle
# time (touch one .cpp, run this, read the elapsed time) against the real
# NUM_COMPILE_THREADS=2 / gcc-12 toolchain configuration this tree is already
# set up with.
#
# IMPORTANT: never change NUM_COMPILE_THREADS, toolchainDir, or any other
# cmake/make-affecting property below. build-webkit diffs the whole args string
# against its cached copy and wipes CMakeCache.txt (forcing a full reconfigure
# and losing all incremental state) if anything in it differs at all -- this
# cost about 45 minutes once already on this exact tree. If you need a
# different configuration, do it in a separate build directory, not this one.
set -euo pipefail
cd "$(dirname "$0")"

LOG_DIR="build/timing-logs"
mkdir -p "$LOG_DIR"

LABEL="${1:-build}"
TIMESTAMP=$(date +%Y%m%d-%H%M%S)
LOG_FILE="$LOG_DIR/${TIMESTAMP}-${LABEL}.log"

echo "Starting WebKit build (label: $LABEL) at $(date)"
START=$(date +%s)

set +e
./gradlew sdk -PCOMPILE_WEBKIT=true -PNUM_COMPILE_THREADS=2 -PtoolchainDir=/home/kenelson/toolchain-gcc12 --console=plain > "$LOG_FILE" 2>&1
STATUS=$?
set -e

END=$(date +%s)
ELAPSED=$((END - START))

printf 'Elapsed: %02d:%02d:%02d (%d seconds)\n' $((ELAPSED/3600)) $((ELAPSED%3600/60)) $((ELAPSED%60)) $ELAPSED
echo "Log: $LOG_FILE"

if [ $STATUS -ne 0 ]; then
    echo "BUILD FAILED (exit $STATUS) -- see $LOG_FILE"
    tail -40 "$LOG_FILE"
    exit $STATUS
fi

echo "BUILD SUCCESSFUL"

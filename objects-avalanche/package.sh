#!/bin/bash -e
source "$(dirname $0)/config.sh"
[ -f Main ] || "$(dirname $0)/build.sh"

rm -fr tmp
mkdir tmp
cp Main tmp
cp run-JET.sh tmp

mkdir tmp/hs
cp *.class tmp/hs
cp run-HS.sh tmp/hs

"${JET_HOME}/bin/xpack" -source tmp -target export \
                        -clean-target -profile auto -zip # || (echo xpack error && exit /b 1)

echo
echo Packaging successful

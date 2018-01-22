#!/bin/bash -e
source "$(dirname $0)/cleanup.sh"
source "$(dirname $0)/config.sh"

"${JAVA_HOME}/bin/javac" Main.java
 #|| (echo javac error && exit /b 1)
"${JET_HOME}/bin/jc" =a Main.class
#|| (echo jc error && exit /b 1)

echo .
echo Build successful


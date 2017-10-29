# export JAVA_HOME=
# export PATH=$JAVA_HOME/bin:$PATH

java -version
javac *.java

# Running the test in mixed compilation mode. 
# Error is expected when using Java 8 or earlier.
java -Xmx4096k Test

# Running the test in interpreted mode execution only.
# Errors are not expected.
java -Xmx4096k -Xint Test
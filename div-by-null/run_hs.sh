#export JAVA_HOME=
#export PATH=$JAVA_HOME/bin:$PATH

java -version
javac *.java

java Test
echo Above ^ should be a complete stack trace of NullPointerException

java Test 2
echo Above ^ should be a complete stack trace of ArithmeticException

# cleaning up
rm *.class
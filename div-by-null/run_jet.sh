# export JAVA_HOME=
# export JET_HOME=
# export PATH=$JAVA_HOME/bin:$JET_HOME/bin:$PATH

javac *.java
jc Test +GenStackTrace > /dev/null

./Test
echo Above ^ should be a stack trace of NullPointerException truncated in main

./Test 2
echo Above ^ should be a stack trace of ArithmeticException truncated in main

# cleaning up
rm -r *.class Test jetpdb
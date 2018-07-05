#export JAVA_HOME=
#export PATH=$JAVA_HOME/bin:$PATH

java -version
javac UnsafeTest.java

java UnsafeTest

# cleaning up
rm *.class
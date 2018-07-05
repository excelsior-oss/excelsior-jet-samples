# export JAVA_HOME=
# export JET_HOME=
# export PATH=$JAVA_HOME/bin:$JET_HOME/bin:$PATH

javac UnsafeTest.java
jc UnsafeTest

./UnsafeTest

# cleaning up
rm -r *.class UnsafeTest jetpdb
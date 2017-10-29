rem set JAVA_HOME=
rem set PATH=%JAVA_HOME%\bin;%PATH%

java -version
javac *.java

rem Running the test in mixed compilation mode. 
rem Error is expected when using Java 8 or earlier.
java -Xmx4096k Test

rem Running the test in interpreted mode execution only.
rem Errors are not expected.
java -Xmx4096k -Xint Test
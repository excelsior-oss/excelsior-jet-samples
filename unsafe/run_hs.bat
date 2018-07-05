@rem set JAVA_HOME=
@rem set PATH=%JAVA_HOME%\bin;%PATH%

javac UnsafeTest.java
java UnsafeTest

@rem cleaning up
@del *.class

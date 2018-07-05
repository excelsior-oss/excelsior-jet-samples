@rem set JAVA_HOME=
@rem set JET_HOME=
@rem set PATH=%JAVA_HOME%\bin;%JET_HOME%\bin;%PATH%

javac UnsafeTest.java
jc UnsafeTest.class
UnsafeTest.exe

@rem cleaning up
@del *.class
@del *.exe
@rmdir jetpdb /s /q
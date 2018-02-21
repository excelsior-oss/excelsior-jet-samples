@rem set JAVA_HOME=
@rem set JET_HOME=
@rem set PATH=%JAVA_HOME%\bin;%JET_HOME%\bin;%PATH%

javac *.java
jc PreciseGCTest

@rem cleaning up
@del *.class
@rmdir jetpdb /s /q
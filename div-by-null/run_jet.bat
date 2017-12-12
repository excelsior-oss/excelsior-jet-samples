@rem set JAVA_HOME=
@rem set JET_HOME=
@rem set PATH=%JAVA_HOME%\bin;%JET_HOME%\bin;%PATH%

javac *.java
jc Test +GenStackTrace >NUL

Test
@echo Above ^^ should be a stack trace of NullPointerException truncated in main

Test 2
@echo Above ^^ should be a stack trace of ArithmeticException truncated in main

@rem cleaning up
@del *.class Test.exe
@rmdir jetpdb /s /q
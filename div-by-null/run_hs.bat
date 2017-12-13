@rem set JAVA_HOME=
@rem set PATH=%JAVA_HOME%\bin;%PATH%

java -version
javac *.java

java Test
@echo Above ^^ should be a complete stack trace of NullPointerException

java Test 2
@echo Above ^^ should be a complete stack trace of ArithmeticException

@rem cleaning up
@del *.class
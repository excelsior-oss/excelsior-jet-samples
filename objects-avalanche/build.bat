@echo off
call cleanup.bat
call config.bat   

%JAVA_HOME%\bin\javac Main.java || (echo javac error && exit /b 1)
%JET_HOME%\bin\jc =a Main.class || (echo jc error && exit /b 1)

echo.
echo Build successful

@rem echo off

call config.bat
if not exist Main.exe call build.bat || exit /b 1

if exist tmp rmdir /s /q tmp
mkdir tmp
cp Main.exe tmp
cp run-JET.bat tmp

mkdir tmp\hs
cp *.class tmp\hs
cp run-HS.bat tmp\hs

%JET_HOME%\bin\xpack -source tmp -target export ^
                     -clean-target -profile auto -zip || (echo xpack error && exit /b 1)
rmdir /s /q tmp

echo.
echo Packaging successful
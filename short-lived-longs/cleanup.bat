@echo off
del /s /q *.class Main.exe export.zip
for %%d in (jetpdb tmp export ) do if exist %%d rmdir /s /q %%d

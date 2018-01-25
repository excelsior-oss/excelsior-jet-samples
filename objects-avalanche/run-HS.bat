@echo off

for %%i in (1 2 3 4 8 16 32 64 128) do (
   java -Xmx100m Main 0 %%i 10000000
)


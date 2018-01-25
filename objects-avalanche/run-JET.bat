
@echo off

set JETVMPROP=-Djet.gc.heaplimit:100m  

for %%i in (1 2 3 4 8 16 32 64 128) do (
   Main.exe 0 %%i 10000000
)


#!/bin/bash

export JETVMPROP=-Djet.gc.heaplimit:100m
for i in 1 2 3 4 8 16 32 64 128
do
   ./Main 0 $i 10000000
done


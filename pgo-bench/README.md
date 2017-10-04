# Profile-Guided Optimization microbenchmark example
Microbenchmark that models a polymorphic collection.
Compiled with PGO, it shows a 8x performance boost compared to the default build.
Try it yourself:

`mvn jet:build` -- to build in the default mode

`mvn jet:run` -- to run just built benchmark

`mvn jet:profile` -- to collect the execution profile

`mvn jet:build` -- to rebuild the benchmark with the profile

`mvn jet:run` -- to run the benchmark with pgo enabled to enjoy 8x performance boost

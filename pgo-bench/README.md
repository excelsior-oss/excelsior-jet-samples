# Profile-Guided Optimization Microbenchmark

A microbenchmark that models iteration over a polymorphic collection.
Enabling Profile-Guided Optimization delivers a 8x performance boost (tested with Excelsior JET 12.)

To try it yourself, [download an Excelsior JET Evaluation Package](https://www.excelsiorjet.com/evaluate), install it, and issue the following Maven commands:

`mvn jet:build` -- build a native binary in the default mode

`mvn jet:run` -- run the binary just built

`mvn jet:profile` -- collect an execution profile

`mvn jet:build` -- re-build (PGO will be enabled automatically)

`mvn jet:run` -- run the benchmark again to observe the performance boost

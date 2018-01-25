**Benchmark illustrating memory manager scalability improvements in
Excelsior JET 14+. Build/run/package scripts provided for Windows and \*ix.**

This benchmark models an application that runs many worker threads in parallel,
with each thread allocating a short-lived object on the heap. 

## Building And Running

First, edit the `config` script as appropriate, then invoke the `build` script 
to build both bytecode and native versions.

Use the `run-*` scripts to run the benchmark.

If you want to run the benchmark on another system, invoke the `package` script
and copy the entire `export` directory to that system (the `export.zip` file 
contains a copy of that directory).

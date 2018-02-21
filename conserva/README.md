# Conservative GC example

This small example demonstrates problems that you can face with when using the conservative GC.
You can read more about it in this article:  [_Conservative GC: Is It Really That Bad?_](https://www.excelsiorjet.com/blog/articles/conservative-gc-is-it-really-that-bad/)

## To run the sample:

1. Edit `build` script and specify values of `JAVA_HOME` and `JET_HOME` variables
2. Run `build` script to build the sample with Excelsior JET
3. Run `run_with_conservative_gc` script. Conservative GC will be used and the test will fail because of OOM error
4. Run `run_with_precise_gc` script. Precise GC will be used as usually and the test will pass successfully (however, it can take a while)
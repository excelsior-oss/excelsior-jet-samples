# Unsafe harbor example

This small example demonstrates that `Unsafe.objectFieldOffset(...)` method can return "negative" but still correct values in case of Excelsior JET.
You can read more about it in this article:  [_Unsafe Harbor_](https://www.excelsiorjet.com/blog/articles/unsafe-harbor/)

## To run the sample:

1. Edit `run_hs` and `run_jet` scripts and specify values of `JAVA_HOME` and `JET_HOME` variables
2. Run both scripts to observe different values of the offset gathered by `Unsafe.objectFieldOffset(...)` method

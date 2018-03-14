# Introduction

`BooleanHell.jasm` contains hand-written class-file which passes integers 0, 1,
2, 3, -1 to `Inverter.invert()` which receives them as `boolean` values.

# Building

```
$ javac Inverter.java
$ java -jar ../asmtools/lib/asmtools.jar jasm BooleanHell.jasm
```

# Running

```
$ java BooleanHell
false (0) -> true (1)
true (1) -> false (0)
true (2) -> false (0)
true (3) -> false (0)
true (-1) -> false (0)
```


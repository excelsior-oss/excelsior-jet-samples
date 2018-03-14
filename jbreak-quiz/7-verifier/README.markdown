# Introduction

`Helper.jasm` contains hand-written class-file with unverifiable method `sayC`.

# Building

```
$ java -jar ../asmtools/lib/asmtools.jar jasm Helper.jasm
$ javac Main.java
```

# Running

```
$ java Main
AException in thread "main" java.lang.VerifyError: (class: Helper, method: sayC signature: ()V) Unable to pop operand off an empty stack
        at Main.main(Main.java:4)
```


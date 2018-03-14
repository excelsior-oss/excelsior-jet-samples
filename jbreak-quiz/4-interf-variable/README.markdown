# Introduction

`TestAsm.jasm` contains hand-written class-file which passes `ArrayList` and
`Integer` instances to `Guesser.guessWhat` which receives them as `Iterable`.

`TestPartialRecompilation` demonstrates the same effect using tricky
partial recompilation: `NotIterable` is first declared as implementing
`Iterable` and then recompiled as not implementing it.

# Building

```
$ javac Guesser.java
$ java -jar ../asmtools/lib/asmtools.jar jasm TestAsm.jasm
$ javac TestPartialRecompilation1.java
$ javac TestPartialRecompilation2.java
```

# Running

```
$ java TestAsm
class java.util.ArrayList
It is instance of Iterable: true
class java.lang.Integer
It is instance of Iterable: false

$ java TestPartialRecompilation
class java.util.ArrayList
It is instance of Iterable: true
class NotIterable
It is instance of Iterable: false
```


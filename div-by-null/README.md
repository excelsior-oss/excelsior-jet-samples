# The Exceptional Case

This small example demostrates the effect discussed in the article
[_An Exceptional Case_](https://www.excelsiorjet.com/blog/articles/an-exceptional-case/).
You better read the article first, because the below is essentially a spoiler.

![Spoiler alert](spoiler-alert.jpg)

The code is organized in a somewhat peculiar way in order to provoke
the compiler to inline both static methods of the class `Int` into its
public instance method `div`, and at the same time preclude it from inlining
the latter into `Test.main`.
After inlining, the compiler optimized the entire body of `div` down to
a single `idiv` CPU instruction, and the sources of NPE and AE thus collide
as described in the above referenced blog post.

Those who don't want to bother building and running the sample,
but are still willing to see what it does, may find its outputs below.

On HotSpot:

    > java Test
    Exception in thread "main" java.lang.NullPointerException
            at Int.val(Test.java:27)
            at Int.div(Test.java:32)
            at Test.main(Test.java:9)
    Above ^ should be a complete stack trace of NullPointerException

    > java Test 2
    Exception in thread "main" java.lang.ArithmeticException: / by zero
            at Int.div(Test.java:36)
            at Int.div(Test.java:31)
            at Test.main(Test.java:9)
    Above ^ should be a complete stack trace of ArithmeticException

On Excelsior JET 14 Beta 1:

    > Test
    Exception in thread "main" java.lang.NullPointerException
            at Test.main(Test.java:9)
    Above ^ should be a stack trace of NullPointerException truncated in main

    > Test 2
    Exception in thread "main" java.lang.ArithmeticException: / by zero
            at Test.main(Test.java:9)
    Above ^ should be a stack trace of ArithmeticException truncated in main


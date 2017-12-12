import java.lang.reflect.InvocationTargetException;

public class Test {
    public static Int a;

    public static void main(String[] args) {
        set_a(); // magic inside to prevent `a.div(b)` from inlining
        Int b = (args.length == 0) ? null : new Int(0);
        a.div(b);
    }

    private static void set_a() {
        try {
            Class.forName("Setter").getDeclaredMethod("set").invoke(null);
        } catch (NoSuchMethodException |
                ClassNotFoundException |
                IllegalAccessException |
                InvocationTargetException ignored) {}
    }
}

class Int {
    private final int val;
    public Int(int v) { val = v; }

    public static int val(Int a) {
        return a.val;
    }

    public int div(Int that) {
        return div(val(this),  // newline intended to show different
                   val(that)); // line numbers in NPE and AE
    }

    public static int div(int a, int b) {
        return a / b;
    }
}

class Setter {
    public static void set() {
        Test.a = new Int(42);
    }
}

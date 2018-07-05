import sun.misc.Unsafe;
import java.lang.reflect.*;

class UnsafeTest {

    public static interface Bar {
        public void print();
    }

    public static class Foo {
        Bar barField;
    }

    public static class Baz implements Bar {

        String place;

        public Baz(String place) {
            this.place = place;
        }

        public void print() {
            System.out.println("Hello from " + place + "!");
        }  
    } 

    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        Field f = Foo.class.getDeclaredField("barField");
        long offset = unsafe.objectFieldOffset(f);
        Foo host = new Foo();        
        unsafe.putObject(host, offset, new Baz("unsafe"));
        System.out.println("offset = " + offset);
        host.barField.print();
    }
}
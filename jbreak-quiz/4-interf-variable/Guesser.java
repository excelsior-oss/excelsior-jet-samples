public class Guesser {
    public static void guessWhat(Iterable<?> x) {
        System.out.println(x.getClass());
        System.out.println("It is instance of Iterable: " + (x instanceof Iterable<?>));
    }
}


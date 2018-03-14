import java.util.*;

class TestPartialRecompilation {
    public static void main(String[] args) {
        Guesser.guessWhat(new ArrayList<Object>());
        Guesser.guessWhat(new NotIterable());
    }
}

class NotIterable implements Iterable<Object> {
    public Iterator<Object> iterator() {
        throw new RuntimeException("should not be called");
    }
}


import java.util.Timer;
import java.util.TimerTask;

public class PreciseGCTest {
    private static class Task extends TimerTask {
        Timer timer;
        int[] array;

        public void run() {
            array = new int[1000000]; // 4 mb
        }

        public Task(Timer t) {
            super();
            this.timer = t;
        }
    }

    public static void main(String args[]) throws Exception {
        for (int i = 0; i < 50; i++) {     // 200 mb max
            Timer t = new Timer();
            t.schedule(new Task(t), 500);
            Thread.sleep(500);
        } // 50mb of heap limit should be enough for this test
        System.out.println("PASSED");
        System.exit(0);
    }
}
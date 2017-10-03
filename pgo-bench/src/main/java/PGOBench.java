abstract class Task { abstract int compute(); }


public class PGOBench {

    static final int WARMUP      = 130000;
    static final int REPETITIONS = 200000;

    static Task[] dataArr;

    public static void main(String[] args) {
        initData();

        long t0 = System.nanoTime();
        bench(dataArr, WARMUP);
        long t1 = System.nanoTime();
        int res = bench(dataArr, REPETITIONS);
        long t2 = System.nanoTime();


        System.out.println("PGO bench: res =" + res);
        System.out.printf("Warm up: %8d iterations, time: %,d\n", WARMUP, t1 - t0);
        System.out.printf("Bench  : %8d iterations, time: %,d\n", REPETITIONS, t2 - t1);
    }


    static int bench(Task[] arr, int reps) {
        int res = 0;
        for (int i = 0; i < reps; i++) {
            for (Task t : arr) {
                res += t.compute();
            }
        }
        return res;
    }

    static final int DATA_SIZE = 4000;

    static void initData() {
        dataArr = new Task[DATA_SIZE];

        for (int i = 0; i < dataArr.length; i++) {
            byte b = (byte)i;

            dataArr[i] = (i % 64 == 0) ? new Byte4Task  (b, b, b, b) : new ByteTask (b);
        }
    }
}


abstract class ComplexTask extends Task {
    abstract byte get0();
    abstract byte get1();
    abstract byte get2();
    abstract byte get3();

    static int compound(byte b0, byte b1, byte b2, byte b3) {
        return ((int)b0) | (((int)b1) << 8) | (((int)b2) << 16) | (((int)b3) << 24);
    }

    int compute() {
        return compound(get3(), get2(), get1(), get0());
    }
}


class ByteTask extends ComplexTask {

    byte b;

    ByteTask (byte b) { this.b = b;}

    byte get0() {return this.b;}
    byte get1() {return 0;}
    byte get2() {return 0;}
    byte get3() {return 0;}

    int compute() {
        return super.compute() + 1;
    }
}


class Byte4Task extends ComplexTask {

    byte b1, b2, b3, b4;

    Byte4Task (byte b1, byte b2, byte b3, byte b4) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
    }

    byte get0() {return this.b1;}
    byte get1() {return this.b2;}
    byte get2() {return this.b3;}
    byte get3() {return this.b4;}

    int compute() {
        return super.compute() + 4;
    }

}


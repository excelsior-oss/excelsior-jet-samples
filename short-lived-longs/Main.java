import java.util.ArrayList;
import java.util.Collection;

public class Main {

  public static volatile Double until;
  public static volatile boolean log = false;

  public static class CpuWorker implements Runnable {
    
    @Override
    public void run() {
      final Long startTime = System.currentTimeMillis();
            
      Double result = 1d;
      Double bound = Main.until;

      for (Double f = 0d; f < bound; f++) {
        result += f / (result + 1);
      }
      
      final Long endTime = System.currentTimeMillis();
      if (log) System.out.println(result);
      if (log) System.out.println(Thread.currentThread().getName() + " finished in " + (endTime - startTime) + "ms");    
    }    
  }

  public static class CpuWorkerPrimitive implements Runnable {
    
    @Override
    public void run() {
      final long startTime = System.currentTimeMillis();
            
      double result = 1d;
      double bound = Main.until;

      for (double f = 0d; f < bound; f++) {
        result += f / (result + 1);
      }
      
      final long endTime = System.currentTimeMillis();
      if (log) System.out.println(result);
      if (log) System.out.println(Thread.currentThread().getName() + " finished in " + (endTime - startTime) + "ms");    
    }    
  }

  
  public static void main(final String[] arg) throws InterruptedException {

    // warmup
    /*
    Main.log = false;
    Main.until = 10000d;
    for (int i =0 ; i < 10_000; i++) {
	    (new CpuWorker()).run();
	    (new CpuWorkerPrimitive()).run();
    }

    System.gc();  
    */

    if (arg.length != 3) {
	System.out.println("java Main <mode> <threads> <iterations_per_thread>");
	System.out.println("  mode = 0 => use boxing");
	System.out.println("  mode = 1 => use primitive");
	return;
    }

    final int mode = Integer.parseInt(arg[0]);
    final int threadCount = Integer.parseInt(arg[1]);
    final int iters = Integer.parseInt(arg[2]);

    Main.log = false;
    Main.until = (double)iters;
    
    final Collection<Thread> threads = new ArrayList<>(threadCount);
  
    for (int threadIndex = 0; threadIndex < threadCount; threadIndex++) {
      Thread t = (mode == 0)
		? new Thread (new CpuWorker(), "CpuWorker-" + threadIndex)
		: new Thread (new CpuWorkerPrimitive(), "CpuWorkerPrimitive-" + threadIndex);
     
      threads.add(t);
    }

    final Long startTime = System.currentTimeMillis();
    System.out.println("Starting " + threadCount + " " + ((mode == 0) ? "object-producing" : "primitive-based") + " threads counting until " + Main.until);
    
    threads.forEach(o -> {
      try {
        o.start();
      } catch(Exception e) {
        e.printStackTrace();
      }
    });

    threads.forEach(o -> {
      try {
        o.join();
      } catch(Exception e) {
        e.printStackTrace();
      }
    });
    
    final Long endTime = System.currentTimeMillis();
    System.out.println("Execution took " + (endTime - startTime) + "ms");    
  }  
}

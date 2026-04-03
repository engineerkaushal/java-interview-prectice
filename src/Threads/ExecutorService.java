package Threads;

import java.util.concurrent.*;
class ASS {
private int i = 0;
    public void incrementWithoutLock() {
        i++;
    }

    private final Object lock = new Object();
    public void incrementWithLock() {
        synchronized (lock) {
            i++;
        }
    }

    public int getI() {
        return i;
    }
}
public class ExecutorService {
    public static void main(String[] args) throws InterruptedException {
        ASS as = new ASS();

        java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i=0; i<10000; i++) {
            executorService.submit(()-> as.incrementWithLock());
        }
        for (int i=0; i<10000; i++) {
            executorService.submit(()-> as.incrementWithLock());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Final Count: "+ as.getI());

    }
}

package Threads;
class T {
    private int count = 0;
    private final Object lock = new Object();

    public void incrementWithoutLock() {
        count++;
    }

    public synchronized void incrementWithKeyLock() {
        count++;
    }

    public void incrementWithBlockLock() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
public class CustomThread {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread t1 = new Thread(()-> {
            for (int i=0; i<10000; i++) {
                t.incrementWithBlockLock();
            }
        });

        Thread t2 = new Thread(()-> {
            for (int i=0; i<10000; i++) {
                t.incrementWithBlockLock();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + t.getCount());
    }
}

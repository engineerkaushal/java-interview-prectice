package Threads;
class SharedObj{
    private volatile boolean flag = Boolean.FALSE;

    public void setFlagTrue() {
        System.out.println("Writer thread made the flag true !");
        flag = Boolean.TRUE;
    }

    public void printIfFlagTrue() {
        while (!flag) {
            // do nothing
        }

        System.out.println("Flag is true !");
    }
}
public class VolatileExample {
    public static void main(String[] args) {
        SharedObj obj = new SharedObj();

        Thread writerThread = new Thread( () -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            obj.setFlagTrue();
        });

        Thread readerThread = new Thread( () -> {
            obj.printIfFlagTrue();
        });

        writerThread.start();
        readerThread.start();
    }
}

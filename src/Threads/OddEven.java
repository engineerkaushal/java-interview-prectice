package Threads;

import java.util.concurrent.Executors;

public class OddEven {
    public static void main(String[] args) throws InterruptedException {
        /*java.util.concurrent.ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()-> {
            for (int i=2; i<10; i+=2) {
                System.out.println(Thread.currentThread().getName()+" Even Therad :"+ i);
            }
        });
        executorService.execute(()-> {
            for (int i=1; i<10; i+=2) {
                System.out.println(Thread.currentThread().getName()+" Odd Therad :"+ i);
            }
        });

        executorService.shutdown();*/

        Thread t1 = new Thread(()-> {
            for (int i=1; i<10; i++) {
                if (i%2!=0) {
                    System.out.println(Thread.currentThread().getName()+":"+ i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Odd");
        Thread t2 = new Thread(()-> {
            for (int i=1; i<10; i++) {
                if (i%2==0) {
                    System.out.println(Thread.currentThread().getName()+":"+ i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"Even");

        t1.start();
        t2.start();
    }
}

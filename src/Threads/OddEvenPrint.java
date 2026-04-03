package Threads;

class Printer {
    private boolean isOddTurn = true;

    // Print odd number
    public synchronized void printOdd(int number) {
        while (!isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + number);
        isOddTurn = false;
        notify();
    }

    // Print even number
    public synchronized void printEven(int number) {
        while (isOddTurn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + number);
        isOddTurn = true;
        notify();
    }
}

public class OddEvenPrint {
    public static void main(String[] args) {
        Printer printer = new Printer();

        // Thread to print odd numbers
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                printer.printOdd(i);
            }
        }, "Odd : ");

        // Thread to print even numbers
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                printer.printEven(i);
            }
        }, "Even : ");

        oddThread.start();
        evenThread.start();
    }
}

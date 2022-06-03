package multithreading;

import java.util.concurrent.Semaphore;

public class EvenOdd {

    private Semaphore evenSemaphore = new Semaphore(0);
    private Semaphore oddSemaphore = new Semaphore(1);

    void printOdd() {
        int number = 1;
        try {
            while (true) {
                oddSemaphore.acquire();
                System.out.println(number);
                number += 2;
                evenSemaphore.release();
                Thread.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void printEven() {
        int number = 0;
        try {
            while (true) {
                evenSemaphore.acquire();
                number += 2;
                System.out.println(number);
                Thread.sleep(100);
                oddSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        EvenOdd evenOdd = new EvenOdd();
        Thread thread1 = new Thread(() -> evenOdd.printEven());
        Thread thread2 = new Thread(() -> evenOdd.printOdd());

        thread1.start();
        thread2.start();
    }
}

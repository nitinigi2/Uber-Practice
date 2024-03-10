package multithreading;

public class EvenOddv2 {
    int counter = 1;
    static int N;

    private static Object lock = new Object();

    public void printEven() {
        synchronized (lock) {
            while (counter < N) {
                while (counter % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(counter);
                counter++;
                lock.notify();
            }
        }
    }

    public void printOdd() {
        synchronized (lock) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(counter);
                counter++;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddv2 oddEven = new EvenOddv2();
        Thread t1 = new Thread(() -> oddEven.printEven());
        Thread t2 = new Thread(() -> oddEven.printOdd());
        N = 100;
        t1.start();
        t2.start();
    }
}

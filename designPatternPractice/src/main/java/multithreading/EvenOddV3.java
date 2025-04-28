package multithreading;

public class EvenOddV3 {
    private int size = 0;
    private static int counter = 1;
    private static Object lock = new Object();

    public static void main(String[] args) {
        int N = 100;
        EvenOddV3 oddEven = new EvenOddV3(N);
        Thread t1 = new Thread(() -> oddEven.printEven());
        Thread t2 = new Thread(() -> oddEven.printOdd());
        t1.start();
        t2.start();
    }

    public EvenOddV3(int size) {
        this.size = size;
    }

    private void printOdd() {
        while (counter <= size) {
            synchronized (lock) {
                if (counter % 2 != 0) {
                    System.out.println(counter);
                    counter++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    private void printEven() {
        while (counter <= size) {
            synchronized (lock) {
                if (counter % 2 == 0) {
                    System.out.println(counter);
                    counter++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


}

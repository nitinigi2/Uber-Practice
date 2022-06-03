package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    private Queue<Integer> queue = new LinkedList<>();
    private Semaphore s1;
    private Semaphore s2;

    public ProducerConsumer(int capacity) {
        s1 = new Semaphore(capacity);
        s2 = new Semaphore(0);
    }

    public void produce() {
        int i = 1;
        try {
            while (true) {
                s1.acquire();
                queue.add(i);
                System.out.println("Data produced: " + i);
                i++;
                s2.release();
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumer() {
        try {
            while (true) {
                s2.acquire();
                int data = queue.poll();
                System.out.println("Data consumed: " + data);
                s1.release();
                Thread.sleep(10);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer(5);
        Thread thread1 = new Thread(() -> producerConsumer.produce());
        Thread thread2 = new Thread(() -> producerConsumer.consumer());

        thread1.start();
        thread2.start();
    }
}

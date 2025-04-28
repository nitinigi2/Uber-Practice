package multithreading;

public class MultipleThreadsRoundRobin {
    public static void main(String[] args) throws InterruptedException {
        int counter = 11;
        int n = 3;
        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new ThreadRunner(i, n, counter);  // Pass thread id and total threads
            threads[i].setName("thread" + (i + 1)); // Set readable names: thread1, thread2, etc.
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }
    }
}

class ThreadRunner extends Thread {

    private static int counter = 1;
    private static final Object lock = new Object();
    private final int threadId;
    private final int totalThreads;
    private final int MAX_COUNT;

    private static final int batchSize = 3;

    public ThreadRunner(int threadId, int totalThreads, int maxCount) {
        this.threadId = threadId;
        this.totalThreads = totalThreads;
        this.MAX_COUNT = maxCount;
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (counter > MAX_COUNT) {
                    lock.notifyAll(); // Notify all threads so they can exit if waiting
                    break;
                }
                int batchNumber = (counter - 1) / batchSize;
                if (batchNumber % totalThreads == threadId) { // Only this thread's turn
                    System.out.println("Thread with id: " + threadId + " :: " + counter);
                    counter++;
                    lock.notifyAll(); // Wake up others
                } else {
                    try {
                        lock.wait(); // Wait for the turn
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

//1,2,3,10 => 1
//4,5,6 => 2
//7,8,9 => 3





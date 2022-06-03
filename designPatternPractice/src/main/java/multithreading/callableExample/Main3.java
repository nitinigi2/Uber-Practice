package multithreading.callableExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(32);

        List<Task> tasks = new ArrayList<>();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            tasks.add(new Task());
        }

        for (Task task : tasks) {
            futures.add(executorService.submit(task));
        }

        for (Future future : futures) {
            int retries = 3;
            while (retries-- > 0) {
                try {
                    future.get(10, TimeUnit.MILLISECONDS);
                    //future.get();
                    System.out.println("Data received");
                    break;
                } catch (TimeoutException e) {

                }
            }
        }

        executorService.shutdown();
    }
}

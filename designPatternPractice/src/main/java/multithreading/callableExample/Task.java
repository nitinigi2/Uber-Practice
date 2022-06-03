package multithreading.callableExample;

import java.util.concurrent.Callable;

public class Task implements Callable {
    @Override
    public String call() throws Exception {
        Thread.sleep(100);
        return "abc";
    }
}

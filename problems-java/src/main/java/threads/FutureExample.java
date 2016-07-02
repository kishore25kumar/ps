package threads;

import java.util.*;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<Future<String>>();
        for(int i = 0; i < 100; i += 1) {
            Future<String> future = executorService.submit(new FutureThread());
            futures.add(future);
        }

        for(Future<String> future : futures) {
            System.out.println(new Date() + "::" + future.get());
        }

        executorService.shutdown();
    }
}

class FutureThread implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}

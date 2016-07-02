package threads;

import java.util.concurrent.*;

public class ExecuterExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i += 1) {
            Runnable runnable = new ExecuterThread();
            executorService.submit(runnable);
        }
    }
}

class ExecuterThread implements Runnable {

    public void run() {
        System.out.println("Executed by thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Execution competed by thread " + Thread.currentThread().getName());
    }
}

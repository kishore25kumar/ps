package threads;

import java.text.*;
import java.util.*;

public class ThreadLocalExample implements Runnable {
    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>() {
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd HHmm");
        }
    };

    private static final ThreadLocal<Integer> number = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for(int i = 0; i < 10; i += 1) {
            Thread t1 = new Thread(threadLocalExample, Integer.toString(i));
            Thread.sleep(new Random().nextInt(1000));
            t1.start();
        }
    }

    public void run() {
        //System.out.println("Currnet thread is " + Thread.currentThread().getName() + " " + formatter.get().toPattern());

        System.out.println("Currnet thread is " + Thread.currentThread().getName() + " " + number.get());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        number.set(100);

        formatter.set(new SimpleDateFormat());

//        System.out.println("Currnet thread is " + Thread.currentThread().getName() + " " + formatter.get().toPattern());

        System.out.println("Currnet thread is " + Thread.currentThread().getName() + " " + number.get());
    }
}

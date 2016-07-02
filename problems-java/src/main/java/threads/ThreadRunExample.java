package threads;

public class ThreadRunExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
        Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");

        t1.start();
        t2.start();

        System.out.println("Starting runnable Threads");

        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");

        t3.start();
        t4.start();

        System.out.println("My threads started");
    }
}

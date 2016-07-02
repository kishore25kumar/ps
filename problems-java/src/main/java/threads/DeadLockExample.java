package threads;

public class DeadLockExample {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }

    private static class Thread1 extends Thread {
        public void run() {
            System.out.println("Starting thread 1");
            System.out.println("Waiting for lock on object 1");
            synchronized (lock1) {
                System.out.println("Took lock on object 1");
                System.out.println("Waiting for lock on object 2");
                synchronized (lock2) {
                    System.out.println("Took lock on object 2");
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        public void run() {
            System.out.println("Starting thread 2");
            System.out.println("Waiting for lock on object 2");
            synchronized (lock2) {
                System.out.println("Took lock on object 2");
                System.out.println("Waiting for lock on object 1");
                synchronized (lock1) {
                    System.out.println("Took lock on object 1");
                }
            }
        }
    }
}

package threads;

public class ThreadSleep {
    public static void main(String[] args) {
        try {
            long time = System.currentTimeMillis();
            Thread.sleep(2000);
            System.out.println("Total sleep time in ms " + (System.currentTimeMillis() - time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package threads;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread dt = new Thread(new DemoThread(), "daemon thread");
        dt.setDaemon(false);
        dt.start();
        Thread.sleep(1000);
        System.out.println("Main is done");
    }

}

class DemoThread implements Runnable {
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Processing Dameon Thread");
        }
    }
}

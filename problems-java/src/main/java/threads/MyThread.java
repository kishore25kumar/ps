package threads;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Normal Thread START " + this.getName());
        try {
            Thread.sleep(1000);
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Normal Thread END " + this.getName());
    }

    private void doWork() throws InterruptedException {
        Thread.sleep(1000);
    }
}

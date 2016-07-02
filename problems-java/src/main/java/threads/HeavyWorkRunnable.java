package threads;

public class HeavyWorkRunnable implements Runnable {
    public void run() {
        System.out.println("Heavy processing START " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            doWork();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Heavy processing END " + Thread.currentThread().getName());
    }

    private void doWork() throws InterruptedException {
        Thread.sleep(1000);
    }
}

package threads.concurrency;

public class Waiter implements Runnable {
    Message message;
    public Waiter(Message message) {
        this.message = message;
    }


    public void run() {
        System.out.println("Waiter started " + Thread.currentThread().getName());
            synchronized (message) {
                try {
                    this.message.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        System.out.println("Waiter thread notified at " + Thread.currentThread().getName() + " " +System.currentTimeMillis());
        System.out.println("Message is " + this.message.getMessage());
    }
}

package threads.concurrency;

public class Notifier implements Runnable {
    Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    public void run() {
        try {
            Thread.sleep(1000);
            synchronized (message) {
                message.setMessage("Notifier has set a new Message");
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Notifier work is done");
    }
}

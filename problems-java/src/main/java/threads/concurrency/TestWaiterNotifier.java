package threads.concurrency;

public class TestWaiterNotifier {
    public static void main(String[] args) {
        Message message = new Message("Hello world");
        Thread waiter1 = new Thread(new Waiter(message), "waiter1");
        waiter1.start();
        Thread waiter2 = new Thread(new Waiter(message), "waiter2");
        waiter2.start();

        Thread notifier = new Thread(new Notifier(message), "notifier1");
        notifier.start();
    }
}

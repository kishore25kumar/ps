package threads;

import java.util.concurrent.*;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(10);
        Producer producer = new Producer(messages);
        Consumer consumer = new Consumer(messages);
        new Thread(producer, "producer").start();
        new Thread(consumer, "consumer").start();
    }
}

class Message {
    String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

class Producer implements Runnable {
    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    public void run() {
        for(int i = 0; i < 100; i += 1) {
            Message message = new Message(" " + i);
            try {
                queue.put(message);
                System.out.println("Produced message " + message.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            queue.put(new Message("exit"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    BlockingQueue<Message> queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        Message msg;
        try {
            while ((msg = queue.take()).getMessage() != "exit") {
                Thread.sleep(10);
                System.out.println("Consumed Message " + msg.getMessage());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package threads;

public class ChatApplication {
    public static void main(String[] args) {
        Chat c = new Chat();
        Thread t1 = new Thread(new Client1(c), "Client1");
        Thread t2 = new Thread(new Client2(c), "Client2");
        t1.start();
        t2.start();
    }
}

class Chat {
    boolean questionAsked = false;
    public synchronized void Question(String question) {
        if (questionAsked) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        questionAsked = true;
        System.out.println(question);
        notify();
    }

    public synchronized void Answer(String answer) {
        if(!questionAsked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        questionAsked = false;
        System.out.println(answer);
        notify();
    }
}

class Client1 implements Runnable {
    Chat c;
    public Client1(Chat c) {
        this.c = c;
    }

    public void run() {
        String[] question = new String[] {"Hi!", "What's up", "Stop PJ"};
        for (int i = 0; i < question.length; i += 1) {
            c.Question(question[i]);
        }
    }
}

class Client2 implements Runnable {
    Chat c;
    public Client2(Chat c) {
        this.c = c;
    }

    public void run() {
        String[] question = new String[] {"Hi", "Fan", "Haha"};
        for (int i = 0; i < question.length; i += 1) {
            c.Answer(question[i]);
        }
    }
}
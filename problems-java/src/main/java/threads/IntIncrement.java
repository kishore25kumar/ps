package threads;

public class IntIncrement {
    public static void main(String[] args) {
        IntHolder intHolder = new IntHolder();

        new Thread1(intHolder).start();
        new Thread2(intHolder).start();
    }
}

class IntHolder {
    public Integer i = 0;
}

class Thread1 extends Thread {
    IntHolder intHolder;

    public Thread1(IntHolder intHolder) {
        this.intHolder = intHolder;
    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (intHolder) {
            for(int i = 0; i < 10; i += 1) {
                this.intHolder.i = this.intHolder.i + 1;
                System.out.println(this.intHolder.i + " Thread 1");
            }
        }
    }
}

class Thread2 extends Thread {
    IntHolder intHolder;
    public Thread2(IntHolder intHolder) {
        this.intHolder = intHolder;
    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (intHolder) {
            for(int i = 0; i < 10; i += 1) {
                this.intHolder.i += 1;
                System.out.println(this.intHolder.i + " Thread 2");
            }
        }
    }
}

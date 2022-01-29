package v.kiselev;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count;

    public Counter() {
        this.count = 0;
    }

    public int increase() {
        Lock lock = new ReentrantLock();
        lock.lock();
        int i = increaseValue();
        lock.unlock();
        return i;
    }

    private int increaseValue() {
        return count++;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " : " + counter.increase());
            }
        }).start();


        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " : " + counter.increase());
            }
        }).start();


        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " : " + counter.increase());
            }
        }).start();


        new Thread(()-> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread: " + Thread.currentThread().getName() + " : " + counter.increase());
            }
        }).start();


    }
}

package v.kiselev;

public class PingPong {

    boolean flag = true;
    String word = "ping";

    synchronized void ping() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        flag = false;
        this.word = "ping";
        System.out.println("ping");
        notify();
    }

    synchronized void pong() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        this.word = "pong";
        System.out.println("pong");
        notify();
    }

    public static void main(String[] args) {
        PingPong ping=new PingPong();

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(1000);
                    ping.ping();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();

        new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(1000);
                    ping.pong();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }).start();


    }
}


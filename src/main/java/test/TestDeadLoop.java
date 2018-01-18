package test;

/**
 * author: 牛虻.
 * time:2018/1/17
 * email:pettygadfly@gmail.com
 * doc:
 */
public class TestDeadLoop {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread1.start();
        synchronized (thread1) {
            thread1.wait();
        }
    }
}

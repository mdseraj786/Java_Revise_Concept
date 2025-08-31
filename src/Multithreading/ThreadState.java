package Multithreading;

public class ThreadState extends Thread{
    @Override
    public void run() {
        System.out.println("Running..");
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState t = new ThreadState();
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(2000);
        System.out.println(t.getState());

        t.join();
        System.out.println(t.getState());
    }
}

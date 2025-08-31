package Multithreading.SynchronisationAndLock;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Counter counter =new Counter();
        MyThread t = new MyThread(counter);
        t.start();
        MyThread t2 = new MyThread(counter);
        t2.start();
        t2.join();
        t.join();
        System.out.println(counter.getCnt());
    }
}

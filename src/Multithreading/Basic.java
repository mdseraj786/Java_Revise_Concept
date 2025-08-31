package Multithreading;

public class Basic {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        World world = new World();
        world.start();
        for (; ; ) {
            System.out.println("hello");

        }

    }
}

class World extends Thread {
    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());
        for (; ; ) {
            System.out.println("world");
        }
    }
}

class Hii implements Runnable {
    @Override
    public void run() {
        for (; ; )
            System.out.println("Hii");
    }
}
class Seraj{
    public static void main(String[] args) {
        Hii hi = new Hii();
        Thread t = new Thread(hi);
        t.start();
        for(;;){
            System.out.println("Seraj");
        }
    }
}
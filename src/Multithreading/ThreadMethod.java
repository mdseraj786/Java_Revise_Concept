package Multithreading;

public class ThreadMethod extends Thread {
    // run start, sleep, join, setPriority,interrupt, yield, setDemon

    public ThreadMethod(String name){
        super(name);
    }
    @Override
    public void run() {
//        try {
//            sleep(0);
////            sleep(10000);
//        } catch (InterruptedException e) {
//            System.out.println("Interrupt : " + e);
//        }
        for (int i = 0; i < 50; i++) {
            System.out.println(this.getName());
//            Thread.yield(); // give the chance to execute others thread
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadMethod t1 = new ThreadMethod("firstThread");
        t1.start();

        SecondThread t2 = new SecondThread();
        t2.start();

//        t1.setPriority(10);
//        t2.setPriority(1);
//        t1.join();

//        t1.interrupt();
//        System.out.println("this is main method----");

    }
}

class SecondThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("Thread - 2");
//            Thread.yield();
        }
    }
}

class SetDaemon extends Thread{
    @Override
    public void run(){
        while (true){
            System.out.println(this.getName());
        }
    }
    public static void main(String[] args) {
        SetDaemon t = new SetDaemon();
        t.setDaemon(true); // stop background task when main has completed
        t.start();

        SetDaemon t1 = new SetDaemon();
        t1.start();
        System.out.println("this is main thread");
    }
}

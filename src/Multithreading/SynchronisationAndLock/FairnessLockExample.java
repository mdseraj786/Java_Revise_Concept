package Multithreading.SynchronisationAndLock;

import Multithreading.ThreadMethod;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
    private Lock lock = new ReentrantLock(true);

    public void accessResources() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the resource");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        finally {
            System.out.println(Thread.currentThread().getName() + " released the resource\n");
            lock.unlock();
        }
    }
}

class TestF{
    public static void main(String[] args) {


        FairnessLockExample f = new FairnessLockExample();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                f.accessResources();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        for(int i=0; i<10; i++){
            Thread t = new Thread(task);
            t.start();
        }
    }
}

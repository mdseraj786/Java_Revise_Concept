package Multithreading.SynchronisationAndLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int cnt = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock read = lock.readLock();
    private Lock write = lock.writeLock();

    public int getCnt() {
        read.lock();
        try {
            return cnt;
        } finally {
            read.unlock();
        }
    }

    public void incrementCnt() {
        write.lock();
        try {
            cnt++;
        } finally {
            write.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // object of class
        ReadWriteLockExample counter = new ReadWriteLockExample();
        // write operation
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " increment ");
                    counter.incrementCnt();
                }
            }
        };
        // read operation
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " read : " + counter.getCnt());
                }
            }
        };


        Thread t1 = new Thread(writeTask);
        Thread t2 = new Thread(readTask);
        Thread t3 = new Thread(readTask);


        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Counter : " + counter.getCnt());
    }
}

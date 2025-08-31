package Multithreading.SynchronisationAndLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    int balance = 100;
    private Lock lock = new ReentrantLock();

    public void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " processing to withdrawal");
                    try {
                        Thread.sleep(5000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " complete withdrawal : current balance = " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    finally {
                        lock.unlock();
                    }

                } else {
                    System.out.println("insufficient balance...");
                }
            } else {
                System.out.println("yaar bahut jayada time ho gya mai jata hu ");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

class TestL {
    public static void main(String[] args) {
        LockExample bank = new LockExample();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                bank.withdraw(50);
            }
        };

        Thread t1 = new Thread(run, "Thread 1");
        Thread t2 = new Thread(run, "Thread 2");

        t1.start();
        t2.start();
    }
}
package Multithreading.SynchronisationAndLock;

public class BankAccount {
    int balance = 100;

    public synchronized void  withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " Attempting to withdraw " + amount);
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName() + " processing to withdrawal");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

            }

            balance -= amount;
            System.out.println("complete withdrawal : current balance = " + balance);
        }
        else {
            System.out.println("insufficient balance...");
        }
    }
}


class TestS {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                bank.withdraw(50);
            }
        };

        Thread t1 = new Thread(run,"Thread 1");
        Thread t2 = new Thread(run,"Thread 2");

        t1.start();
        t2.start();
    }
}

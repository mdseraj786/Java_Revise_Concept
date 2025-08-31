package Multithreading.SynchronisationAndLock;

public class MyThread extends Thread{
    Counter counter;

    MyThread(Counter c){
        this.counter = c;
    }

    @Override
    public void run(){
        for(int i=0; i<1000; i++) {
            counter.increase();
        }
    }
}

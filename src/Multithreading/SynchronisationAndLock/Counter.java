package Multithreading.SynchronisationAndLock;

public class Counter {
    int cnt = 0; // shared resource

    public synchronized void increase(){
        this.cnt++;
    }

    public int getCnt(){
        return this.cnt;
    }
}

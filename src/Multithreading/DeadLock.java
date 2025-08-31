package Multithreading;

class Pen{
    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to use paper" + paper);
        paper.finishedWriting();
    }
    public synchronized void finishedWriting(){
        System.out.println(Thread.currentThread().getName() + " finished writing using pen " + this);
    }
}

class Paper{
    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to use pen " + pen);
        pen.finishedWriting();
    }
    public synchronized void finishedWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

class Task1 implements Runnable{
    private final Pen pen ;
    private final Paper paper;

    public Task1(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        //synchronized(paper) {
            pen.writeWithPenAndPaper(paper); // thread1 locks pen and tries to lock paper
      //  }
    }
}
class Task2 implements Runnable{
    private final Pen pen ;
    private final Paper paper;

    public Task2(Pen pen, Paper paper) {
        this.pen = pen;
        this.paper = paper;
    }

    @Override
    public void run() {
        synchronized (pen) {
            paper.writeWithPaperAndPen(pen);// thread1 locks paper and tries to lock pen
        }
    }
}
public class DeadLock {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();

        Thread t1 = new Thread(new Task1(pen,paper));
        Thread t2= new Thread(new Task2(pen,paper));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("work is done");
    }
}
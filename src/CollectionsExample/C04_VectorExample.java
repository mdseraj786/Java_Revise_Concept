package CollectionsExample;

import java.util.LinkedList;
import java.util.Vector;

public class C04_VectorExample {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.add(1,5);

        System.out.println(v);


        System.out.println("\n ---------------------------------- \n");
        System.out.println("Testing synchronise and Non synchronise");

        LinkedList<Integer> list = new LinkedList<>();
        Vector<Integer> vector = new Vector<>();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000; i++){
                    list.add(1);
                    vector.add(1);
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<1000; i++){
                    vector.add(1);
                    list.add(1);
                }
            }
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable1);
        t1.start();
        t2.start();
        t1.join();t2.join();
        System.out.println(list.size()); // not thread safe
        System.out.println(vector.size()); // thread safe
    }

}
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
    }
}

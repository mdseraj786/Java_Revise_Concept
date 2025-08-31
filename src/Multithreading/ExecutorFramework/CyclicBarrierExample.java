package Multithreading.ExecutorFramework;



import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample extends Thread {
    private CyclicBarrier barrier;

    public CyclicBarrierExample(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("hello ");
            sleep(2000);
            barrier.await();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

class Main{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CyclicBarrier barrier = new CyclicBarrier(3);

        executor.submit(new CyclicBarrierExample(barrier));
        executor.submit(new CyclicBarrierExample(barrier));
        executor.submit(new CyclicBarrierExample(barrier));

        System.out.println("this is main method....");
        executor.shutdown();

    }
}
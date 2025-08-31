package Multithreading.ExecutorFramework;

import java.util.concurrent.*;

public class CountDownLatchExample implements Callable<String> {
    private CountDownLatch latch;
    public CountDownLatchExample(CountDownLatch latch){
        this.latch = latch;
    }
    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName() + " services started");
            Thread.sleep(2000);
        } finally {
            latch.countDown();
        }
        return null;
    }
}

class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int noOfServices = 3;
        ExecutorService executor = Executors.newFixedThreadPool(noOfServices);
        CountDownLatch latch = new CountDownLatch(noOfServices);

        Future<String> future = executor.submit(new CountDownLatchExample(latch));
        Future<String> future1 = executor.submit(new CountDownLatchExample(latch));
        Future<String> future2 = executor.submit(new CountDownLatchExample(latch));

//        future.get();
//        future1.get();
//        future2.get();
        latch.await();

        executor.shutdown();
        System.out.println("main working");
    }

}

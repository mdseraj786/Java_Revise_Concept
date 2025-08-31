package Multithreading.ExecutorFramework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService e = Executors.newSingleThreadExecutor();
        Future<?> futureNull = e.submit(() -> {
            System.out.println("hello");
        });
        System.out.println(futureNull.get());// blocking call(null)
        if (futureNull.isDone()) {
            System.out.println("Task is done...");
        }
        futureNull.get();

        Future<Integer> future = e.submit(() -> {
            return 31313;
        });
        System.out.println(future.get()); // blocking call
        if (future.isDone()) {
            System.out.println("Task is done...");
        }
        future.get();
        e.shutdown();
    }
}

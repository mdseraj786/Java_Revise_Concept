package Multithreading.ExecutorFramework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExamples {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("worker");
            return "ok";
        });
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("worker");
            return "ok";
        });
        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("worker");
            return "ok";
        }).thenApply(x -> x+x + "seraj");

        System.out.println(cf2.get());

        CompletableFuture<Void> f = CompletableFuture.allOf(cf, cf1);
        f.join();
        System.out.println("main thread");
    }
}

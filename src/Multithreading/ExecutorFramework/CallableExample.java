package Multithreading.ExecutorFramework;

import java.util.concurrent.*;

public class CallableExample implements Callable<String> {

    @Override
    public String call() throws Exception {
        return " Task Completed";
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newSingleThreadExecutor();

        Future<String> future = ex.submit(new CallableExample());

            String s = future.get();
            System.out.println(s);

        ex.shutdown();
    }
}

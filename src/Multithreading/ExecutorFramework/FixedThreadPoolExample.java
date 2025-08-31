package Multithreading.ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing task " + taskId);
        try {
            Thread.sleep(2000); // Simulating task execution
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has completed task " + taskId);
    }
}

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Creating a fixed thread pool of 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submitting 6 tasks to the executor
        for (int i = 1; i <= 6; i++) {
            executor.execute(new Task(i));
        }

        // Shutting down the executor after task submission
        executor.shutdown();
    }
}

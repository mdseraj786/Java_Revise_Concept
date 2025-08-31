package Multithreading.ExecutorFramework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class SchedulerExample {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService sch = Executors.newScheduledThreadPool(3);
        System.out.println("Scheduling time : " + System.currentTimeMillis());
        sch.scheduleAtFixedRate(()->{ // schedule again and again
            System.out.println("schedule at fixed rate after 5 sec : " + System.currentTimeMillis()) ;
        },0,5, TimeUnit.SECONDS);

        sch.schedule(()->{ // schedule at one time after running this method
            System.out.println("schedule after 3 sec : " + System.currentTimeMillis()) ;
        },12, TimeUnit.SECONDS);


        sleep(15000);
        sch.shutdown();
    }
}

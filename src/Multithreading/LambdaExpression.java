package Multithreading;

public class LambdaExpression {
    public static void main(String[] args) {
        Runnable t = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello ");
            }
        };
        Runnable t1 = () -> {
            System.out.println("Hello");
        };
        Runnable t2 = () -> System.out.println("hello");

        Thread tt = new Thread(t);
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);

        Thread tt3 = new Thread(() -> System.out.println("hello..."));
        Thread tt4 = new Thread(()->{
            for(int i=0; i<5; i++){
                System.out.println("hello....");
            }
        });

        tt.start();
        tt1.start();
        tt2.start();
        tt3.start();
        tt4.start();
    }
}

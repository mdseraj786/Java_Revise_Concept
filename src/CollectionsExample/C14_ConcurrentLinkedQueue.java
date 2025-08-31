package CollectionsExample;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class C14_ConcurrentLinkedQueue {
}
// An implementation of the queue interface that supports lock-free, thread-safe operations


class TaskSubmissionSystem{
    static ConcurrentLinkedQueue<String> taskQueue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) {


        Thread producer = new Thread(() -> {
            while (true) {
                taskQueue.add("Task" + System.currentTimeMillis());
            }
        });

        Thread consumer = new Thread(() -> {
            String task = taskQueue.poll();
            System.out.println("Processing: " + task);
        });

        producer.start();;
        consumer.start();;;;

    }
}

class ConcurrentLinkedDequeDemo{
    public static void main(String[] args) {
//         non-blocking, thread-safe double-ended queue
//        compare and swap method

        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        // all deque methods are allowed
        deque.add("e1");
        deque.addFirst("e0");
        deque.addLast("e3");

        System.out.println(deque);
    }
}

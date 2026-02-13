package CollectionsExample;

import java.util.concurrent.*;

public class C13_BlockingQueueDemo {
}

class BlockingQueueDemo {
    static class Producer implements Runnable {
        private BlockingQueue<Integer> queue;
        private int value = 0;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Producer produced: " + value + "    size = " + queue.size());
                    queue.put(value++);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Producer interrupted");
                }

            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<Integer> queue;
        private int value = 0;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer value = queue.take();
                    System.out.println("Consumer consumed: " + value + "    size = " + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Consumer interrupted");
                }

            }
        }
    }

    public static void main(String[] args) {
        // thread-safe queue
        // wait for queue to become non-empty/ wait for space, simplify concurrency problems like producer-consumer
        // standard queue --> immediately
        // empty --> remove ( no waiting )
        // full --> add ( no waiting )
        // Blocking Queue
        // put --> Blocks if the queue is full until space becomes available
        // take --> Blocks if the queue is empty until and element becomes available
        // offers --> Waits for space to become available, up to the specified timeout

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        // A bounded, Blocking queue backed by circular array
        // low memory overhead , more threads --> more problems
        // use a single lock for both enqueue and dequeue operation
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();

        BlockingQueue<Integer> deque1 = new LinkedBlockingQueue<>();
        // Optionally bounded backed by LinkedList
        // Uses two separate locks for enqueue and dequeue operations
        // Higher concurrency between producers and consumers

        BlockingQueue<Integer> deque2 = new PriorityBlockingQueue<>();
        // unbounded, put won't block
        // Binary Heap as array and grow dynamically
        // Head is based on their natural ordering or a provided Comparator
        //
    }
}

class SynchronousQueueDemo {
    public static void main(String[] args) {
        // each insert operation must wait for a corresponding remove operation by another thread and vice versa
        // it cannot store elements , capacity of at most one element

        BlockingQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread(() -> {
            try {
                System.out.println("producer is waiting to transfer....");
                queue.put("hello from producer!");
                System.out.println("Producer has transferred the message");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted");
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is waiting to receive.....");
                String message = queue.take();
                System.out.println("Consumer received : " + message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted");
            }
        });

        producer.start();
        consumer.start();


    }
}

class DelayQueueDemo {

    static class DelayedTask implements Delayed {
        private String taskName;
        private long startTime;

        public DelayedTask(String taskName, long delay, TimeUnit unit) {
            this.taskName = taskName;
            this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
        }

        public String getTaskName() {
            return taskName;
        }

        public long getStartTime() {
            return startTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remaining = startTime - System.currentTimeMillis();
            return unit.convert(remaining, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.startTime < ((DelayedTask) o).startTime) {
                return -1;
            }
            if (this.startTime > ((DelayedTask) o).startTime) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//         Thread-safe unbounded blocking queue
//         Elements can only be taken from the queue when their delay has expired
//        Useful for scheduling tasks to ve executed after a certain delay
//        Internally priority queue

        BlockingQueue<DelayedTask> queue = new DelayQueue<>();

        queue.put(new DelayedTask("T1", 2, TimeUnit.SECONDS));
        queue.put(new DelayedTask("T2", 3, TimeUnit.SECONDS));
        queue.put(new DelayedTask("T3", 1, TimeUnit.SECONDS));
        queue.put(new DelayedTask("T4", 4, TimeUnit.SECONDS));

        while (!queue.isEmpty()) {
            System.out.println("loop");
            DelayedTask task = queue.take(); // block until a task's delay has expired
            System.out.println("Executed : " + task.getTaskName() + " at " + System.currentTimeMillis());
        }
    }
}




package CollectionsExample;

import java.util.*;
import java.util.concurrent.*;

public class C12_QueueDemo {
    public static void main(String[] args) {
        // linked list also acts as queue
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);// enqueue
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        System.out.println(list);
        list.removeFirst(); // dequeue
        System.out.println(list);
        list.getFirst(); // peek

//      Queue implementation using Queue interface
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);// enqueue
        queue.add(2);
        queue.add(3);
        queue.offer(4);

        System.out.println(queue);

        System.out.println(queue.remove()); // dequeue, give exception if element is not present
        System.out.println(queue.poll()); // doesn't give exception, it returns null if data not present

        System.out.println(queue);
        System.out.println(queue.element()); // peek,  give exception if element is not present
        System.out.println(queue.peek()); //  doesn't give exception, it returns null if data not present
    }
}

class PriorityQueueDemo {
    public static void main(String[] args) {
        // part of the Queue interface, Custom comparator   for customised ordering, doesn't allow null elements
        // orders elements based on their natural ordering(for primitives lowest first)

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(63);
        pq.add(90);
        pq.add(30);
        pq.add(72);

        System.out.println(pq); // not sorted
        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.poll();
        }

//      Internal working
        // priority queue is implemented as a min-heap by default (for natural ordering)
    }
}

class DequeDemo {
    public static void main(String[] args) {
//        double-ended queue
//        allows insertion and removal of elements from both ends
//        versatile than regular queue and stacks because they support all the operations of both
/*
           INSERTION METHODS
           addFirst, addLast, offerFirst , offerLast
           REMOVAL METHODS
           removeFirst, removeLast, pollFirst, pollLast

           STACK METHODS
            push(E e) :
            pop() :
*/
        Deque<Integer> deque = new ArrayDeque<>();
        // faster iteration, low memory, no null allowed, circular --> head and tail
        // no need to shift elements, just shift head and tail
        deque.addFirst(29);
        deque.addLast(74);
        deque.offerLast(78);
        deque.offerFirst(83);

        System.out.println(deque);
    }
}


























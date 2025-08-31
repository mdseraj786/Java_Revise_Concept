package CollectionsExample;

import java.util.LinkedList;

public class C03_LinkedListExample {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1,12);
        list.addFirst(121);
        list.addLast(1213);


        list.removeIf(x-> x%2==0);

        System.out.println(list);
    }
}

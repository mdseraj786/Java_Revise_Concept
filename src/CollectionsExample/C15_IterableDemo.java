package CollectionsExample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class C15_IterableDemo   {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for(int i : list){
            System.out.println(i);
        }

        // this is internal working of enhance for loop
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        // we can remove element during the loop without using copyOnWriteArrayList
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer num = iterator.next();
            if(num % 2 == 0)
                iterator.remove();
        }
        System.out.println(list);

        ListIterator<Integer> integerListIterator = list.listIterator();
        while(integerListIterator.hasNext()){
//            here there are more method to iterator
            integerListIterator.add(8);
            break;
        }
        System.out.println(list);
    }
}

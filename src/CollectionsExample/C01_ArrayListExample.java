package CollectionsExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C01_ArrayListExample {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("seraj");
        list.add("seraj");
        list.add(2,"aniket");
        list.set(1,"raju");

        List<Integer> listInt = List.of(1,9,2,7,6,3,4);
        List<Integer> listAsList = Arrays.asList(1, 2, 3,4);
        List<Integer> list1 = new ArrayList<>(13);
        list1.add(14);
        list1.addAll(listInt);


        list1.remove(4); // it will take index
        list1.remove(Integer.valueOf(14)); // it will take object

        // convert list to array
        Integer[] array = list1.toArray(new Integer[0]);// here size 0 passed just for convention
        for(int i: array) System.out.print(i + " ");
        System.out.println();
        System.out.println(list1);


        // sorting in list
        Collections.sort(list);
        System.out.println(list);

        list1.sort(null); // null means sort naturally
        System.out.println(list1);
    }
}

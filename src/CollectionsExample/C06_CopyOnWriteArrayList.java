package CollectionsExample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class C06_CopyOnWriteArrayList {
    public static void main(String[] args) {
//        List<String> arr = new ArrayList<>();
//        arr.add("eggs");
//        arr.add("apple");
//        arr.add("bread");
//
//        System.out.println("initial shopping list " + arr);
//        for(String s : arr){
//            System.out.println(s);
//            if(s.equals("eggs")){
//                arr.add("butter");
//                System.out.println("Added butter while reading,.....");
//            }
//        }
//        System.out.println("updated shopping list " +arr); //ConcurrentModificationException

        List<String> arr1 = new CopyOnWriteArrayList<>();
        arr1.add("eggs");
        arr1.add("apple");
        arr1.add("bread");

        System.out.println("initial shopping list " + arr1);
        for(String s : arr1){
            System.out.println(s);
            if(s.equals("eggs")){
                arr1.add("butter");
                System.out.println("Added butter while reading,.....");
            }
        }
        System.out.println("updated shopping list " + arr1); //ConcurrentModificationException solve this problem
    }
}

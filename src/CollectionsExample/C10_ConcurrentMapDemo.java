package CollectionsExample;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class C10_ConcurrentMapDemo {
}

class HashTableDemo {
    public static void main(String[] args) throws InterruptedException {
        Hashtable<Integer, String> hashtable = new Hashtable<>();
        // hashtable is synchronized , no null key or value, slower than hashmap
        // Legacy class --> replaced by concurrentHashMap, only linked list in case of collision
        // all methods are synchronized

        hashtable.put(1, "one");
        hashtable.put(2, "two");
        hashtable.put(3, "three");

        System.out.println(hashtable.containsKey(2));
        System.out.println(hashtable.get(3));


        // concurrent problem

//        HashMap<Integer,String> conMap = new HashMap<>(); // here size of hashmap is less than 2000
        Hashtable<Integer, String> conMap = new Hashtable<>(); // here size of hashmap is equal to 2000

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                conMap.put(i, "Thread 1");
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                conMap.put(i, "Thread 2");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(conMap.size());
    }
}

class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> conMap = new ConcurrentHashMap<>();
        // java 7 --> segment based locking --> 16 segments -- smaller hashmaps
        // only the segment based being written to or read from is locked
        // read : do not require locking unless there is a write operation happening on the same segment
        // write : lock

        // java 8  --> no segmentation
//                --> Compare-And-Swap approach -- no locking except resizing or collision
//        Thread A lsat saw -- x = 45
//      Thread A working -- x to 50
//        if x is still 45, then change it to 50 else don"t ch ange and retry


    }
}

class ConcurrentSkipListMapDemo {

//        SkipList data structure --> probabilistic data structure
//       1 layer -> 1 ----- 5 ------ 9 , 2nd layer -> 1 -- 3 -- 5 -- 7 -- 9 , 3rd layer -> 1 2 3 4 5 6 7 8 9

    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put(2, "apple");


        System.out.println(concurrentSkipListMap);
    }
}

class EnumMapDemo{
    public static void main(String[] args) {
//        HashMap<Day,String> map = new HashMap<>(); // here it will not know all possible key and create problem to rehashing

//      array of size same as enum, no hashing, ordinal/index is used
//      faster than HashMap, Memory efficient
        EnumMap<Day,String> eMap = new EnumMap<>(Day.class); // here it will know all possible keys and no need to rehashing
        eMap.put(Day.TUESDAY,"gym");
        eMap.put(Day.MONDAY,"walk");
        System.out.println(Day.TUESDAY.ordinal());
        System.out.println(eMap); // order maintains by same as enum
    }
}
enum Day{
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY , SATURDAY, SUNDAY
}


class ImmutableMapDemo{
    public static void main(String[] args) {
        Map<Integer,Integer> map1 = new HashMap<>();
        map1.put(1,1);
        map1.put(2,1);

        Map<Integer, Integer> map2 = Collections.unmodifiableMap(map1);
//        map2.put(3,3); // throws UnsupportedOperationException

        // it has limitation only for 10 key value pairs
        Map<Integer, Integer> map3 = Map.of(1, 1, 2, 2, 3, 3, 4, 4);
//        map3.put(5,5); // throws UnsupportedOperationException

        // here is no limitation for key value pairs
        Map<Integer, Integer> map4 = Map.ofEntries(Map.entry(1, 2), Map.entry(2, 3));


    }
}












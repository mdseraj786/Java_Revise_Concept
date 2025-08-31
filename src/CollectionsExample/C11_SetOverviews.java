package CollectionsExample;

import java.util.Collections;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class C11_SetOverviews {
    public static void main(String[] args) {
//         Set is a collection that cannot contain duplicate elements
//        faster operations
//        Map --> HashMap, LinkedHashMap, TreeMap, EnumMap
//        Set --> HashSet, LinkedHashSet, TreeSet, EnumSet


        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);

        System.out.println(set);
        
//        for thread safe

        // this is not recommended
//        Set<Integer> integers = Collections.synchronizedSet(set);
//        synchronized (integers){
//            for(Integer i : integers){
//                System.out.println(i);
//            }
//        }


        Set<Integer> set1 =  new ConcurrentSkipListSet<>();
        ConcurrentSkipListSet<Integer> set2 =  new ConcurrentSkipListSet<>();
        NavigableSet<Integer> set3 =  new ConcurrentSkipListSet<>();


//      unmodifiable sed

        Set<Integer> unmodifiableSet = Set.of(1, 2, 3, 3, 4, 5, 5, 6);
        Set<Integer> unmodifiableSet1 = Collections.unmodifiableSet(set);

    }
}

class CopyOnWriteArraySetDemo{
    public static void main(String[] args) {
        // Thread-Safe , Copy-On-Write Mechanism,
        // No Duplicate Elements, Iterators Don't Reflect Modifications

        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        for(int i=0; i<5; i++){
            concurrentSkipListSet.add(i);
            copyOnWriteArraySet.add(i);
        }

        System.out.println("Initial ConcurrentSkipListSet: " + concurrentSkipListSet);
        System.out.println("Initial CopyOnWriteArraySet: " + copyOnWriteArraySet);

        System.out.println("\n Iteration and modification CopyOnWriteArraySet");
        for(int i : copyOnWriteArraySet){
            System.out.println("Reading from CopyOnWriteArraySet : " + i);
            copyOnWriteArraySet.add(6);
        }
        System.out.println(copyOnWriteArraySet);

          System.out.println("\n Iteration and modification ConcurrentSkipListSet");
        for(int i : copyOnWriteArraySet){
            System.out.println("Reading from ConcurrentSkipListSet : " + i);
            if(i == 4)
                concurrentSkipListSet.add(6);
            // here it is print that why this is called weakly consistent (it may be print if it is added before last element)
        }

    }
}

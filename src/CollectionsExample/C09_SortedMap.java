package CollectionsExample;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class C09_SortedMap {
}


// insertion, deletion --> O(logN) , traversal --> O(n)
class SortedMapDemo{
    public static void main(String[] args) {
        SortedMap<Integer,String> map = new TreeMap<>();
        map.put(83,"sarfraj");
        map.put(84,"amit");
        map.put(91,"RAJU");
        map.put(73,"KESHAV");
        map.put(63,"RANJAN");

        System.out.println(map);
        System.out.println(map.firstKey());
        System.out.println(map.lastEntry());
        System.out.println(map.headMap(83)); // exclusive
        System.out.println(map.tailMap(61)); // inclusive
        System.out.println(map.subMap(63,83)); // toKey is exclusive

        System.out.println("--------------------------------------------------");

        NavigableMap<Integer,String> navMap = new TreeMap<>();
        navMap.put(1,"one");
        navMap.put(5,"five");
        navMap.put(3,"three");
        navMap.put(2,"two");

        System.out.println(navMap.floorEntry(5));
        System.out.println(navMap.ceilingEntry(4));
        System.out.println(navMap.higherEntry(1));
        System.out.println(navMap.descendingMap());
    }
}
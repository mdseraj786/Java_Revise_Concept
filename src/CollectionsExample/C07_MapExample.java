package CollectionsExample;

import java.util.*;

public class C07_MapExample {
}
// value may be null more than one but key can be only one null accepted
class HashmapDemo{
    public static void main(String[] args) {
        HashMap<Integer,String> hash = new HashMap<>();
        hash.put(1,"seraj");
        hash.put(3,"sarfraj");
        hash.put(4,"jishan");
        hash.put(2,"aman");
        hash.put(8,"aman");

        hash.put(null,"aman");

        System.out.println(hash.containsKey(4));
        System.out.println(hash);

//        Set<Integer> keySet = hash.keySet();
        for(int i : hash.keySet()){
            System.out.println(hash.get(i));
        }

        Set<Map.Entry<Integer, String>> entries = hash.entrySet();
        for(Map.Entry<Integer, String> entry : entries){
            entry.setValue(entry.getValue().toUpperCase());
//            System.out.println("key : "+entry.getKey() + "  value : "+entry.getValue());
        }
        System.out.println(hash);
    }
}

class LinkedHashMapDemo{
    public static void main(String[] args) {
        // it maintains the insertion order
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(11,.8f,true);
        linkedHashMap.put("seraj",11);
        linkedHashMap.put("amit",14);
        linkedHashMap.put("salman",12);
        linkedHashMap.put("kumar",51);

        linkedHashMap.get("seraj"); // when we true access order this is put at last
        linkedHashMap.get("salman");
        for(Map.Entry<String,Integer> entry : linkedHashMap.entrySet()){
            System.out.println("key : " + entry.getKey() +" value : " + entry.getValue());
        }
    }
}

class LRUCache<K,V> extends LinkedHashMap<K,V>{
    int capacity;

    public LRUCache(int capacity){
        super(capacity,0.8f,true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache<String,Integer> lruCache = new LRUCache<>(3);
        lruCache.put("seraj",11);
        lruCache.put("amit",14);
        lruCache.put("salman",12);
        lruCache.get("seraj"); // it used before capacity full that why it is not removed
        lruCache.put("kumar",51);
        System.out.println(lruCache);
    }
}

// not more important use for caching
class WeakHashMapDemo{
    public static void main(String[] args) {
        WeakHashMap<String,Image> weakHashMap = new WeakHashMap<>();

        loadCache(weakHashMap);
        System.out.println(weakHashMap);
        System.gc();
        simulation();
        System.out.println("cache after running (some entries may be cleared) " + weakHashMap);
    }

    private static void simulation() {
        try {
            Thread.sleep(10000);
        }
        catch (Exception ignored){

        }
    }

    private static void loadCache(WeakHashMap<String, Image> weakHashMap) {
        String key1 = new String("img1");
        String key2 = new String("img2");
        weakHashMap.put(key1,new Image("Image 1"));
        weakHashMap.put(key2,new Image("Image 2"));

    }
}

class IdentityHashmap{
    public static void main(String[] args) {
        String key1 = new String("key");
        String key2 = new String("key");
//        Map<String,Integer> idMap = new HashMap<>(); // key=2
        Map<String,Integer> idMap = new IdentityHashMap<>(); // {key=2, key=1}
        // here use hashcode to identify the class (yaha kewal memory address ke sath khela jata hai)
//        identityHashcode and == to check the equality
        idMap.put(key1,1);
        idMap.put(key2,2);

        System.out.println(idMap);
    }
}



class SortedMapExample{
    public static void main(String[] args) {

    }
}
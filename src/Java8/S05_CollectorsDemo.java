package Java8;

import java.util.*;
import java.util.stream.Collectors;

public class S05_CollectorsDemo {
    public static void main(String[] args) {
        /*
         Collectors is a utility class
         provides a set of methods to create common collectors

       */

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice");

//        1. Collecting to a List
        List<String> result = names.stream()
                .filter(x -> x.toLowerCase().startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(result);

//        2. Collection to a Set
        Set<String> set = names.stream().collect(Collectors.toSet());
        System.out.println(set);

//       3. Collection to a Specific Collection
        ArrayDeque<String> specificCollector = names.stream()
                .collect(Collectors.toCollection(() -> new ArrayDeque<>()));

//       4. Joining Strings - concatenates stream elements into a single string

        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        ;
        System.out.println(concatenatedNames);

//       5. Summarizing Date
//         Generates statistical summary ( count, sum, min, average, max )
        List<Integer> number = Arrays.asList(1, 3, 4, 6, 3, 2, 1);
        IntSummaryStatistics stats = number.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("sum: " + stats.getSum());
        System.out.println("max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());

//        6. Calculating Average
        Double average = number.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " + average);

//        7. Counting elements
        long count = number.stream().collect(Collectors.counting());
        System.out.println("Count: " + count);

//        8. Grouping Elements
        List<String> words = Arrays.asList("hello", "world", "java", "stream", "collecting");
        System.out.println(words
                .stream()
                .collect(Collectors.groupingBy(String::length)));

        System.out.println(words
                .stream()
                .collect(Collectors.
                        groupingBy(String::length, Collectors.joining(", "))));


        System.out.println(words
                .stream()
                .collect(Collectors.
                        groupingBy(String::length, Collectors.counting())));

        TreeMap<Integer, Long> treeMap = words.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

//        9. Partitioning Elements
        // partitions elements into two groups (true and false ) based on a predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));


//        10. Mapping and Collecting
        // applies a mapping function before collecting
        List<String> collect = words.stream().collect(Collectors.mapping(x -> x.toUpperCase(), Collectors.toList()));
        System.out.println(collect);


//      Example 1 : Collecting Names by length
        System.out.println("\n Example 1");
        List<String> l1 = List.of("Anna", "Bob", "Alexander", "Brain", "Alice");
        System.out.println(l1
                .stream()
                .collect(Collectors.groupingBy(String::length)));

//        Example 2 : counting word occurrences
        String sentence = "hello world hello java world";
        System.out.println(
                Arrays.stream(sentence.split(" "))
                        .collect(Collectors.groupingBy(x -> x , Collectors.counting())));

//        Example 3 : partitioning even and odd number
        List<Integer> l2 = List.of(1, 3, 3, 4, 3, 2, 5, 6);
        System.out.println(l2.stream()
                .collect(Collectors.partitioningBy(x -> x%2==0)));

//        Example 4 : Summing values in a map
        HashMap<String, Integer> items = new HashMap<>();
        items.put("apple",10);
        items.put("banana",20);
        items.put("orange",15);
        System.out.println(items.values().stream()
                .reduce(Integer::sum));
        System.out.println(items.values().stream()
                .collect(Collectors.summingInt(x -> x)));

//        Example 5 : creating a map from stream elements
//        List<String> fruits = Arrays.asList("apple", "banana", "cherry");
//        Map<String, Integer> map = fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length()));
//        System.out.println(map);

//        Example 6 :
//        List<String> fruits1 = Arrays.asList("apple", "banana", "cherry","apple","banana","apple");
//        fruits1.stream().collect(Collectors.toMap(k->k, v->v, (x,y) -> x+y));

    }

}

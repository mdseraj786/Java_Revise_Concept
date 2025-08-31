package Java8;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class S03_IntermediateOps {
    public static void main(String[] args) {
/*
    Intermediate operations transform a stream into another stream
    They are lazy, meaning they don't execute until a terminal operation is invoked

    ## OPERATIONS
 */
//        1. filter
        List<String> list = Arrays.asList("seraj", "amit", "sarfraj", "reyaj", "aniket", "seraj");
        Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("s"));
        // no filtering at this point

        long result = list.stream().filter(x -> x.startsWith("s")).count();
        System.out.println(result);

//        2. map
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

//        3. sorted
        Stream<String> sorted = list.stream().sorted();
        Stream<String> sortedSteamUsingComparator = list.stream().sorted((a, b) -> b.length() - a.length());

//        4. distinct
        long countDistinctNameStartWithS = list.stream().filter(x -> x.startsWith("s")).distinct().count();
        System.out.println(countDistinctNameStartWithS);

//        5. limit
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1).limit(100);
        System.out.println(iterate.count());

//        6. Skip
        Stream<Integer> iterateSkip = Stream.iterate(1, x -> x + 1).skip(10).limit(100);
        // here size of stream is 100, but it's skip 10 first values, and start from 11

//        7. peek - performs an action on each element as it is consumed
        Stream.iterate(1, x -> x + 1).limit(100).peek(System.out::println).count();

//        8. flatMap
       /*
       Handle streams of collections, lists, or arrays where each element is itself a collection
       Flatten nested structures (e.g. - lists within lists) so that they can be processed as a single sequence of elements
       Transform and flatten elements at the same time.
      */
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("pear", "grapes")
        );
        System.out.println(listOfLists.get(1).get(1));
        System.out.println(listOfLists.
                stream().flatMap(x -> x.stream())
                .map(String::toUpperCase)
                .toList());

        List<String> sentences = Arrays.asList(
                "hello world",
                "java stream are powerful",
                "flatMap is useful"
        );
        System.out.println(sentences
                .stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toUpperCase)
                .toList());
    }
}

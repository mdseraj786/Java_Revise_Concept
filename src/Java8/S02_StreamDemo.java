package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class S02_StreamDemo {
    public static void main(String[] args) {
 /*
    ### DEFINITION
       feature introduced in Java 8
       process collections of date in a functional and declarative manner
       Simplify Data Processing, Embrace Functional Programming
       Improve Readability and Maintainability , Enable Easy Parallelism

     ### What is stream ?
        a sequence of elements supporting functional and declarative programming

     ### How to use Streams ?
        Source, Intermediate operations & terminal operation

 */
//        Problem - count even number
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        long count = numbers.stream().filter(x -> x % 2 == 0).count();
        System.out.println(count );

//     ### Creating Streams
//        1. From collections
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> stream = list.stream();
        
//        2. From Arrays
        int[] array = {1,2,3,3,4,4};
        IntStream stream1 = Arrays.stream(array);

//        3. Using Stream.of()
        Stream<String> stream2 = Stream.of("a","b");

//        4. Infinite stream
        Stream<Integer> infinite = Stream.generate(() -> 1);
        Stream<Integer> limit = Stream.generate(() -> 1).limit(100);

        Stream.iterate(1, x -> x + 1);



    }
}

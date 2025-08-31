package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S04_TerminalOperations {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 2, 9, 4, 2, 8, 3);

//        1. collect
        list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

//        2. forEach
        list.stream().forEach(System.out::println);

//        3. reduced -> combines elements to produce a single result
        Optional<Integer> optionalInteger = list.stream().reduce(Integer::sum);
        System.out.println(optionalInteger.get());

//        4. count

//        5. anyMatch, allMatch, nonMatch
        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);
        boolean allMatch = list.stream().allMatch(x -> x > 0);
        System.out.println(allMatch);
        boolean noneMatch = list.stream().noneMatch(x -> x % 2 == 0);
        System.out.println(noneMatch);

//        6. findFirst, findAny
        Optional<Integer> first = list.stream().findFirst();
        System.out.println(first.get());
        Optional<Integer> any = list.stream().findAny();
        System.out.println(any.get());

//      7. toArray
        Object[] array = Stream.of(1, 1, 1, 2, 3, 3).toArray();

//        8. min / max
        System.out.println(Stream.of(92, 82, 74, 42).min(Comparator.naturalOrder())); // 44
        System.out.println(Stream.of(92, 82, 74, 42).max((a1,a2) -> a2 - a1)); // 44

//        9. forEachOrdered
        List<Integer> number0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Using forEach with parallel stream");
        number0.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream");
        number0.parallelStream().forEachOrdered(System.out::println);


//        Example: summing values
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 3, 4);
        System.out.println(numbers.stream().reduce(Integer::sum));

//        Example: Counting Occurrences of a Character
        String sentence = "Hello world";
        long count = sentence.chars().filter(x -> x == 'l').count(); // .chars() return IntStream
        System.out.println(count);


//        NOTE - Stream cannot be reused after a terminal operation has been called
        Stream<Integer> stream = numbers.stream();
        stream.forEach(System.out::println);
//        List<Integer> list1 = stream.map(x -> x * 2).toList(); // exception occure

    }
}

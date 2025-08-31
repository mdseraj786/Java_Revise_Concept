package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class LazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");

        Stream<String> stream = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.length() > 3;
                });
        System.out.println("Before terminal operation");

        List<String> result = stream.collect(Collectors.toList());
        System.out.println("After terminal operation");
        System.out.println(result);
    }
}

class ParallelStreamDemo{
    public static void main(String[] args) {
/*
    A type of stream that enables parallel processing of elements
    Allowing multiple threads to process parts of the stream simultaneously
    This can significantly improve performance for large data sets
    Working is distributed across multiple threads

*/
        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x+1).limit(20000).toList();
        List<Long> factorialStream = list.stream().map(ParallelStreamDemo::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();

        factorialStream = list.parallelStream().map(ParallelStreamDemo::factorial).toList();
//        factorialStream = list.parallelStream().map(ParallelStreamDemo::factorial).sequential().toList(); // use sequential to convert parallelStream to normal stream
         endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream: " + (endTime - startTime) + " ms");

//        Parallel streams are most effective for CPU-intensive or large datasets where tasks are independent
//        They may add overhead for simple tasks or small dataset

//        Cumulative sum
//        [1,2,3,4,5] --> [1, 3, 6, 10, 15 ]
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> cumulativeSum = num.parallelStream().map(x -> sum.addAndGet(x)).toList();
        System.out.println("Expected cumulative sum: [1, 3, 6, 10, 15 ]");
        System.out.println("Actual result with parallel stream: "+ cumulativeSum);
    }

    private static long factorial(int n){
        long result = 1;
        for(int i=2; i<=n; i++){
            result *= i;
        }

        return result;
    }
}
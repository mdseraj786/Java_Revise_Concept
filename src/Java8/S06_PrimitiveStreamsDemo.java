package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class S06_PrimitiveStreamsDemo {
    public static void main(String[] args) {
        Integer[] wrapper =  {1,3,4,5,8};
        Stream<Integer> wrapperStream = Arrays.stream(wrapper);

        int[] primitive =  {1,3,4,5,8};
        IntStream primitiveStream = Arrays.stream(primitive);

//      .boxed() - means converted IntStream to Stream
        System.out.println(IntStream.range(1,10).boxed().collect(Collectors.toList()));// 1 inclusive & 10 exclusive
        System.out.println(IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList()));// both inclusive

        IntStream.of(1,2,34,4);

        DoubleStream doubles = new Random().doubles(5);
//        System.out.println(doubles.max());
        doubles.mapToInt(x -> (int) x + 1);
//        System.out.println(doubles.boxed().toList());


        IntStream ints = new Random().ints(10);
        System.out.println(ints.boxed().toList());
    }
}

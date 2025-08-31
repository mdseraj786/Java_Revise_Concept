package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class S01_Java8Basics {

    interface MathOperation {
        int operation(int a, int b);
    }


    public static void main(String[] args) {

        // Java 8 --> minimal code , functional programing
        // Java 8 --> lambda expression, Streams, Data & Time API

//      ###   Lambda Expression,
        // Lambda expression is an anonymous function ( no name, no return type, no access modifier)
        // It is used to implementing functional interface ( interface which has only one abstract methode)
        Thread t1 = new Thread(() -> {
            System.out.println("hello");
        });

//      ** functional interface can hold lambda expression
        MathOperation sumOperation = (int a, int b) -> {
            return a + b;
        };
        int sum = sumOperation.operation(1, 3);
        System.out.println(sum);

        MathOperation subOperation = (int a, int b) -> a - b;
        System.out.println(subOperation.operation(4, 2));

        MathOperation multiOperation = (a, b) -> a * b;
        System.out.println(multiOperation.operation(3, 8));

//    ###  Predicate --> Functional interface (Boolean valued function ) it holds conditional value
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(4));

        Predicate<String> isWordStartWithA = x -> x.toLowerCase().startsWith("s");
        Predicate<String> isWordEndWithJ = x -> x.toLowerCase().endsWith("j");
        Predicate<String> and = isWordStartWithA.and(isWordEndWithJ);
        System.out.println(and.test("seraj"));

//    ### Function --> work for you
        Function<Integer, Integer> doubleIt = x -> 2 * x;
        Function<Integer, Integer> tripletIt = x -> 3 * x;
        System.out.println(doubleIt.andThen(tripletIt).apply(20)); // 120
        System.out.println(doubleIt.compose(tripletIt).apply(20)); // same
        System.out.println(tripletIt.andThen(doubleIt).apply(20)); // same

        Function<Integer, Integer> identity = Function.identity(); // it is static method and return same output for input
        Integer res = identity.apply(19);
        System.out.println(res);

//    ### Consumer -> it takes input but doesn't return any value
        Consumer<Integer> print = x -> System.out.println(x);
        print.accept(1999);

        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x) {
                System.out.println(i);
            }
        };
        printList.accept(list);

//   ### Supplier  -> doesn't require any parameter but it always returns value
        Supplier<String> giveHelloWorld = () -> "Hello World !";
        System.out.println(giveHelloWorld.get());

//   ### BiPredicate, BiConsumer, BiFunction
        BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
        System.out.println(isSumEven.test(3, 9));
        BiConsumer<Integer, String> biConsumer = (x, y) -> {
            System.out.println(x);
            System.out.println(y);
        };
        biConsumer.accept(93939, "seraj");

        BiFunction<String, String, Integer> biFunction = (x, y) -> (x + y).length();
        System.out.println(biFunction.apply("seraj", "test"));


//    ### UnaryOperator(Function) --> use same data for take parameter and return
        UnaryOperator<Integer> unaryOperator = x -> x * 10;
        System.out.println(unaryOperator.apply(18));

//    ### BinaryOperator(BiFunction) --> use same data for take two parameters and return
        BinaryOperator<Integer> binaryOperator = (x,y) -> (x+y) * 10;
        System.out.println(binaryOperator.apply(18,10));

//    ### Method Reference --> use method without invoking & in placed of lambda expression
        List<String> students = Arrays.asList("seraj","aniket", "hamid");
        students.forEach((x) -> System.out.println(x) );
        students.forEach(System.out::println);

//    ### Constructor reference
        List<String> names = Arrays.asList("A","B","C");
        List<MobilePhone> mobilePHones = names.stream().map(x -> new MobilePhone(x)).collect(Collectors.toList());
        List<MobilePhone> mobilePHones1 = names.stream().map(MobilePhone::new).collect(Collectors.toList());



    }

    static class MobilePhone{
        String name ;
        public MobilePhone(String name){
            this.name = name;
        }
    }
}

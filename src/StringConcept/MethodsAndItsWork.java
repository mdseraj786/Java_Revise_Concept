package StringConcept;

import java.util.Arrays;

public class MethodsAndItsWork {
    public static void main(String[] args) {
        // methods

        String s = "HelloWorld";
        //
        System.out.println(s.length());// 10

        System.out.println(s.charAt(2));// l

        System.out.println(s.substring(5));// World

        System.out.println(s.substring(0, 5));// hello

        System.out.println(s.indexOf("o"));// 4

        System.out.println(s.lastIndexOf("o"));// 6

        System.out.println(s.contains("ello"));// true

        String s1 = s.replace("o", "a");
        System.out.println(s1);// HellaWarld

        System.out.println(s.toUpperCase());// HELLOWORLD
        System.out.println(s.toLowerCase());// helloworld

        String s2 = "  Hello World    !!!  ";// trim first or last space
        System.out.println(s2.trim());// Hello World !!!

        String s3 = "Hello";
        String s4 = "World";
        String s5 = s3.concat(s4);
        System.out.println(s5);// HelloWorld

        String a = "this is my house";
        String[] b = a.split(" ");// create array of string seperated by " "(space)
        for (String b1 : b) {
            System.out.println(b1);
        }

        String aa = "hello";
        String bb = new String("hello");

        System.out.println(aa == bb);// check reference (false)
        System.out.println(aa.equals(bb)); // check value of object (true)

        System.out.println(aa.startsWith("hel"));// (true)
        System.out.println(aa.endsWith("rds"));// (false)

        System.out.println(aa.getBytes());// [B@372f7a8d

        char[] chArray = aa.toCharArray();
        for (char c : chArray) {
            System.out.print(c + ", ");// h, e, l, l, o,
        }
        System.out.println();

        // if the string matches a regex pattern.
        String str = "hello123";
        System.out.println(str.matches(".*\\d.*"));// (true) - here it is check any number(digit) present or not --
                                                   // there are more regex pattern you can learn.

        // intern() Returns the reference from the string pool.
        String string1 = new String("java").intern();
        String string2 = "java";
        if (string1 == string2) {// (true)
            System.out.println("this is true");
        } else {
            System.out.println("this is wrong");
        }

        System.out.println(string1.compareTo("jata"));// 2
        // compareTo compare character by character using ascii value
        // java compareTo jata
        // j==j -> 0 a==a -> 0 v>t -> 2 a==a -> 0 --->> total sum = 2
    }
}

class demo3 {
    public static void main(String args[]) {
        byte[] arr = { 97, 98, 99, 100, 101 };
        String str2 = new String(arr);// one of String constructor takes array of byte to create string
        System.out.println(str2);

        // int[] arr1 = { 97, 98, 99, 100, 101 };
        // str2 = new String(arr1);// String has no constructor for int[], so it fails
        // at compile time.
        // System.out.println(str2);
    }
}

class demo5 {
    public static void main(String args[]) {
        String str = "Java Programming";
        char arr[] = new char[10];
        str.getChars(0, 6, arr, 0);// begin,end, charArray, destBegin in charArray
        System.out.println(arr);// Java P
    }
}

class demo8 {
    public static void main(String args[]) {
        String str = "Java Programming";
        String str1 = "Programminggggg";

        if (str.regionMatches(5, str1, 0, 11))//str.regionMatches(5, str1, 0, 11) checks if 11 characters from index 5 of str match the first 11 characters of str1.
            System.out.println("Same");

        String[] nums = new String[] { "1", "9", "10" };
        Arrays.sort(nums);// Sorting is lexicographical, so "1" < "10" < "9" based on character-by-character dictionary order.
        System.out.println(Arrays.toString(nums));//[1, 10, 9]

        String[] strings = new String[2];
        System.out.println(strings);

    }
}

class Copier {

    public static void main(String... original) {// using vararg(variable argument) 

        // String... copy = original;
        String[] copy = original;
        // String... original is just a String[], so you can assign it to another array (String[] copy = original) but you cannot redeclare a new String... variable like String... copy.
        System.out.println(copy.length + " " + copy[0]);

    }
}

class Count {

    public static void main(String target[]) {

        System.out.println(target.length);

    }
}

class EchoFirst {

    public static void main(String[] args) {

        String one = args[0];

        Arrays.sort(args);

        int result = Arrays.binarySearch(args, one);// using Arrays binarySearch method to find the first argument first string

        System.out.println(result);
    }
}
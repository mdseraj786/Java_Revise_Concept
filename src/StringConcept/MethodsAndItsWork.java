package StringConcept;

import java.util.Arrays;

public class MethodsAndItsWork {
    public static void main(String[] args) {
//        methods

        String s = "HelloWorld";
        //
        System.out.println(s.length());

        System.out.println(s.charAt(2));

        System.out.println(s.substring(5));

        System.out.println(s.substring(0,5));

        System.out.println(s.indexOf("o"));
        System.out.println(s.lastIndexOf("o"));

        System.out.println(s.contains("ello"));

        String s1 = s.replace("o","a");
        System.out.println(s1);

        

        System.out.println(s1.toUpperCase());
        System.out.println(s1.toLowerCase());

        String s2 = "  Hello World    !!!  ";
        System.out.println(s2.trim());

        String s3 = "Hello";
        String s4 = "World";
        String s5 = s3.concat(s4);
        System.out.println(s5);

        String a = "this is my house";
        String[] b = a.split(" ");
        for(String b1:b){
            System.out.println(b1);
        }

        String aa = "hello";
        String bb = new String("hello");

        System.out.println(aa==bb);// check reference
        System.out.println(aa.equals(bb)); // check value of object

        System.out.println(aa.startsWith("hel"));
        System.out.println(aa.endsWith("rds"));

        System.out.println(aa.getBytes());


        char[] chArray = aa.toCharArray();
            for (char c : chArray) {
                System.out.print(c + ", ");
            }
        System.out.println();

        //if the string matches a regex pattern.
        String str = "hello123";
        System.out.println(str.matches(".*\\d.*"));

        //intern()	Returns the reference from the string pool.
        String string1 = new String("java").intern();
        String string2 = "java";
        if(string1==string2){
            System.out.println("this is true");
        }
        else{
            System.out.println("this is wrong");
        }


        System.out.println(string1.compareTo("jata"));;
    }
}
class demo3 {
    public static void main(String args[])
    {
        byte[] arr = { 97, 98, 99, 100, 101 };
        String str2 = new String(arr);

        System.out.println(str2);
    }
}
class demo5 {
    public static void main(String args[])
    {
        String str = "Java Programming";
        char arr[] = new char[10];
        str.getChars(0, 10, arr, 5);
        System.out.println(arr);
    }
}
class demo8 {
    public static void main(String args[])
    {
        String str = "Java Programming";
        String str1 = "Programminggggg";

        if (str.regionMatches(5, str1, 0, 11))
            System.out.println("Same");

        String[] nums = new String[] { "1", "9", "10" };

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));

        String[] strings = new String[2];

        System.out.println(strings);

    }
}

 class Copier {

    public static void main(String... original) {

//        String... copy = original;
//
//        System.out.println(copy.length + " " + copy[0]);

    }    }
 class Count {

    public static void main(String target[]) {

        System.out.println(target.length);

    } }

 class EchoFirst {

    public static void main(String[] args) {

        String one = args[0];

        Arrays.sort(args);

        int result = Arrays.binarySearch(args, one);

        System.out.println(result);   }   }
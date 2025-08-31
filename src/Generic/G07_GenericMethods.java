package Generic;

public class G07_GenericMethods {
    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        String[] stringArr = {"seraj", "rahul", "sarfraj", "Jishan"};


        Util.arrayPrint(intArr);
        Util.arrayPrint(stringArr);
    }
}

class Util {
    public static <T> void arrayPrint(T[] arr) {
        for (T a : arr) {
            System.out.println(a);
        }
    }
}
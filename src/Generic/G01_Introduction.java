package Generic;

import java.util.ArrayList;
import java.util.List;

public class G01_Introduction {
    public static void main(String[] args) {
        // without generic
        List list = new ArrayList();
        list.add("seraj");
        list.add(100); // No error, but might cause ClassCastException

        String ss = (String)list.get(0);
//        String s = (String)list.get(1); // Causes the runtime error
        System.out.println(ss);

        // with generic
        List<String> withGeneric = new ArrayList<>();
        withGeneric.add("name "); // no need to the type casting

//        withGeneric.add(15); // give the compile time error: int can't be converted to String

    }
}

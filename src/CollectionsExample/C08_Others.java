package CollectionsExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class C08_Others {
}

class HashcodeAndEqualsDemo{
    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<>();
        Person p1 = new Person(1,"seraj"); // hashcode1 --> index1
        Person p2 = new Person(2,"aman");  // hashcode2 --> index2
        Person p3 = new Person(1,"seraj");  // hashcode1 --> index1 after overriding custom hashcode and equal method

        map.put(p1,"doctor");
        map.put(p2,"teacher");
        map.put(p3,"engineer");

        System.out.println(map.size());
        System.out.println(map);
    }
}

class ComparableExample{
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(2,"seraj",4.4));
        list.add(new Student(6,"amit",8.4));
        list.add(new Student(3,"aftab",7.4));
        list.add(new Student(9,"astrakhan",9.4));

        list.sort(null);
        System.out.println(list);
    }

}
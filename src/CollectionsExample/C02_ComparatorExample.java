package CollectionsExample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

class MyComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) { // positive - second, first
        return o2-o1;                           // negative - first, second
    }
    // 5 3 
}
class StringComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o2.length() - o1.length();   // desc order by length of string
    }
    // seraj     aniket
}

class Custom implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.mark-o2.mark < 0) return -1;
        else if(o1.mark-o2.mark > 0) return 1;
        else return o1.name.compareTo(o2.name); // if equal compare by using lexicography
    }
}

class Test{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(4);
        list.add(2);

        System.out.println("Before sorting : " + list);
        list.sort(null);
        System.out.println("after ascending sorting : " + list);
        
        MyComparator comparator = new MyComparator();
        
        list.sort(comparator);
        System.out.println("after descending sorting : " + list);

        System.out.println("\n --------------------------------------\n");
        List<String> str = new ArrayList<>();
        str.add("seraj");
        str.add("vikram");
        str.add("aniket");
        str.add("nazim");

        System.out.println("Before sorting : " + str);
        str.sort((a,b)->{
            return a.length()-b.length();
        });
        System.out.println("after ascending sorting : " + str);

        StringComparator comparator1 = new StringComparator();

        str.sort(comparator1);
        System.out.println("after descending sorting : " + str);

        System.out.println("\n --------------------------------------\n");
        System.out.println("sorting costume data like class ");
        List<Student> stu = new ArrayList<>();
        stu.add(new Student(1,"aniket",4.7));
        stu.add(new Student(2,"seraj",3.9));
        stu.add(new Student(3,"hamid",4.7));
        stu.add(new Student(4,"raju",3.7));

        Custom c = new Custom();
        stu.sort(c);
        System.out.println(stu);
    }
}


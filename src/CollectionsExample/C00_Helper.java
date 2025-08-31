package CollectionsExample;

import java.util.Objects;
import java.util.StringJoiner;

public class C00_Helper {
}
class Student implements Comparable<Student>{
    int id;
    String name;
    double mark;

    Student(int id,String s, double d){
        this.id = id;
        this.name = s;
        this.mark = d;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("mark=" + mark)
                .toString();
    }
//      4.compareTo(3) --> 4 , 3
    @Override
    public int compareTo(Student o) {
//       return o.mark - this.mark;

        return Double.compare(o.mark,this.mark);
    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

class Image{
    String name;

    public Image(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
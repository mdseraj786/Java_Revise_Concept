package Generic;

class Box<T>{
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
public class G02_GenericClass {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setValue("cube");
        System.out.println(stringBox.getValue());

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(154);
        System.out.println(integerBox.getValue());


    }
}
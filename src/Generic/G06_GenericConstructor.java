package Generic;

public class G06_GenericConstructor {
    public static void main(String[] args) {
        GenericConstructor g = new GenericConstructor(86868);
        g.show();
    }

}

class GenericConstructor {
    private double value;

    <T extends Number> GenericConstructor(T value) {
        this.value = value.doubleValue();
    }


    void show() {
        System.out.println("This value is : " + value);
    }
}
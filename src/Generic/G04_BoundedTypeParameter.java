package Generic;

public class G04_BoundedTypeParameter {
    public static void main(String[] args) {

//        Calculator<String> cal = new Calculator<>("15"); this is not allowed
        Calculator<Integer> cal1 = new Calculator<>(15);
        System.out.println( cal1.square());;
    }
}



class Calculator<T extends Number>{
    private T num;
    public Calculator(T num){
        this.num = num;
    }
    public double square(){
        return num.doubleValue()*num.doubleValue();
    }
}
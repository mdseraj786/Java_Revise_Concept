package Generic;

public class G03_GenericInterface implements Cube<Double> {

   private double side;

    @Override
    public void setSide(Double side) {
        this.side = side;
    }

    @Override
    public Double getSide() {
        return side;
    }

    public static void main(String[] args) {
        G03_GenericInterface g = new G03_GenericInterface();
        g.setSide(1.111);
        System.out.println(g.getSide());
    }
}

interface Cube<T>{

    void setSide(T side);

    T getSide();
}

package Serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class De_serialize {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("ob.txt");

            ObjectInputStream ois = new ObjectInputStream(fis);

            Student student = (Student) ois.readObject();

            System.out.println(student);

        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

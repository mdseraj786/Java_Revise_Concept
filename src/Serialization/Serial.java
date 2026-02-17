package Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        // create object of student
        
        Student student = new Student("Seraj","seraj@gmail.com", 21, "bhopal");

        FileOutputStream fos = new FileOutputStream("ob.txt");

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        
        // how to serialize 
        oos.writeObject(student);
        
        
        oos.close();
        fos.close();

        System.out.println("Object stated is transfer to file ob !!");
    }
}

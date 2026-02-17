package Serialization;


import java.io.*;

public class CustomSerialization {
    public static void main(String[] args) {
        Person person = new Person("John", 30);
        
        // Serialization with custom behaviour
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))){
            oos.writeObject(person);
            System.out.println("Serialization Successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialization with custom behaviour
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))){
            Person deserializedPerson = (Person) ois.readObject();
            
            System.out.println("Deserialized Person: " + deserializedPerson);
        }
        catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class Person implements Serializable {
    private String name;
    private int age ;
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    private void writeObject(ObjectOutputStream oos) throws IOException{
        // custom serialization logic
        oos.defaultWriteObject(); // this writes the default fields
        
        oos.writeObject("Custom field: " + name); // custom data
    }
    
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        // custom deserialization logic
        ois.defaultReadObject(); // this reads the default fields
        
        String customField = (String) ois.readObject(); // custom data

        System.out.println("Deserialized custom field: " + customField);
    }
    
    @Override
    public String toString(){
        return "Name: " + name + ", Age: " + age;
    }
}
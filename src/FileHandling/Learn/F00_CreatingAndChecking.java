package FileHandling.Learn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class F00_CreatingAndChecking {
    public static void main(String[] args) {
        createAndDelete();
//        
//        create();
        checkFileOrDirectory();
        
    }
    
    public static void createAndDelete(){
        File file = new File("example.txt");
        try {
            if(file.createNewFile()){
                System.out.println("File Created: " + file.getAbsolutePath());
            }
            else{
                System.out.println("File Already exists"+file.getAbsolutePath());
                System.out.println("Size: "+ file.length() + " bytes");
                
                Scanner sc = new Scanner(System.in);
                System.out.println("Delete file? (y/n): ");
                String ans = sc.nextLine().toLowerCase();
                if(ans.equals("y")){
                    boolean deleted = file.delete();
                    System.out.println("Deleted? " + deleted);
                }
            }
        } catch (IOException e) {
            System.out.println("something wrong in this");
            throw new RuntimeException(e);
        }
    }
    // create file using Files.createFile(---)
    public static void create(){
        Path path = Paths.get("example.txt");
        try {
        if(!Files.exists(path)){
            
                Files.createFile(path);
                System.out.println("File created");
                
            
        }else{
            System.out.println("File Already exists"+ path);

            Scanner sc = new Scanner(System.in);
            System.out.println("Delete file? (y/n): ");
            String ans = sc.nextLine().toLowerCase();
            if(ans.equals("y")){
                 Files.delete(path);
                System.out.println("Deleted");
            }
        }} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // check file or directory
    public static void checkFileOrDirectory(){
        File file = new File("example.txt");
        File file1 = new File("Generic");
        if(file.isFile()) System.out.println("Is a file");
        if(file1.isDirectory()) System.out.println("Is a directory");
    }
}

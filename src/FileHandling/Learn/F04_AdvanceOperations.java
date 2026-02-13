package FileHandling.Learn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class F04_AdvanceOperations {
    public static void moveAndRenamingFile() {
        try {
            Files.move(Paths.get("example.txt"), Paths.get("newDir/new.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copyFile() {
        try {
            Files.copy(Paths.get("newDir/new.txt"), Paths.get("newDir/newCopy.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void delete(){
        try {
            Files.delete( Paths.get("newDir/newCopy.txt"));
            System.out.println("deleted");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void directoryTraversal(){
        // list all .txt files in directory and subdirectories
        
        try{
            Files.walk(Paths.get("newDir"))
                    .filter(Files::isRegularFile)
                    .filter(p -> p.toString().endsWith(".txt"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void main(String[] args) {
//        moveAndRenamingFile();
//        copyFile();
//        delete();
        directoryTraversal();
        
    }
}

package FileHandling.Learn;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class F02_DirectoryOperation {
    public static void createDirectory() throws IOException {
        // single
//        Files.createDirectory(Paths.get("newDir"));
        // All -- only last directory created 
        Files.createDirectory(Paths.get("newDir/parent/child"));
    }
    
    public static void listDirectory(){
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("newDir"))){
            for(Path entry : stream){
                System.out.println(entry.getFileName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
//        createDirectory();
        listDirectory();
    }
    
}

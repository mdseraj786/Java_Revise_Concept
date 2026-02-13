package FileHandling.Learn;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class F01_WritingText_ReadingText {
    public static void main(String[] args) throws IOException {
        // writingText();

//        writingBinaryData();
//        readText();
        readByteData();
        
    }

    public static void writingText() throws IOException {
        // using FileWriter
        try (FileWriter fw = new FileWriter("example.txt")) {
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Hello, world!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // using Files.write(--)
        Files.write(Paths.get("example.txt"), "Hello, world!".getBytes(), StandardOpenOption.APPEND);

    }

    public static void writingBinaryData() {
        byte[] data = {65, 66, 67};
        // using fileOutputStream
        try (FileOutputStream fos = new FileOutputStream("data.bin")) {
            fos.write(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.write(Paths.get("data1.bin"), data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readText() {
        // using buffered reader
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // using java.nio
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("example.txt"));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void readByteData(){
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("data.bin"));
            for(byte i : bytes)
                System.out.println(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

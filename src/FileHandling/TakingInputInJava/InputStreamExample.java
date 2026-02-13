package FileHandling.TakingInputInJava;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample{
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;

        System.out.print("Type something and press enter: ");
        int data = is.read(); // read only one byte

        System.out.println("ASCII Value: " + data);
        System.out.println("Character: " + (char) data);
    }
}

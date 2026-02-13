package FileHandling.TakingInputInJava;

import java.io.DataInputStream;
import java.io.IOException;

public class DataInputStreamExample {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(System.in);

        System.out.print("Enter text: ");
        String input = dis.readLine();// deprecated

        System.out.println("you entered : " + input);
    }
}

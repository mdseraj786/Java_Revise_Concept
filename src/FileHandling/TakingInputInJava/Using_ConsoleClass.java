package FileHandling.TakingInputInJava;

import java.io.Console;

public class Using_ConsoleClass {
    public static void main(String[] args) {
        Console c = System.console();
        
        if(c== null){
            System.out.println("Console not available");
            return;
        }
        String name = c.readLine("Enter your name: ");
        char[] password = c.readPassword("Enter password: ");

        System.out.println("name: " + name);
        System.out.println("Password length: " + password.length);
    }
}

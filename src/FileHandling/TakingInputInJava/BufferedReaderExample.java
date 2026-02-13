package FileHandling.TakingInputInJava;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
//       simpleInput();
        
        
    }
    public static void arrayInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter size: ");
        int n = Integer.parseInt(br.readLine());

        System.out.print("Enter array elements: ");
        String[] parts = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
    
    public static void simpleInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("enter text: ");
        String input = br.readLine(); // read full line

        System.out.println("you entered: " + input);
    }
   
    
}

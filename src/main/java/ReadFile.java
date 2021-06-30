import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try{
            File hello = new File("hello.txt");
            Scanner scanner = new Scanner(hello); //use Scanner class to read the contents of the text file
            while(scanner.hasNextLine()){
                String text = scanner.nextLine();
                System.out.println(text);
            }

            scanner.close(); 

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

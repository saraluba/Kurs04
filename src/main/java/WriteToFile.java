import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try{
            FileWriter fileWriter = new FileWriter("hello.txt");
            fileWriter.write("Hello File World!"); //write() method allows us to put text to the file
            fileWriter.close(); //we should always close file after done writing
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

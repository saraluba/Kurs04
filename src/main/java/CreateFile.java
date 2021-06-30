import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try{ //try block is necessary because if the file can't be created it throws IOException
            File hello = new File("hello.txt");
            if(hello.createNewFile()){ //method createNewFile() returns true if the file was created
                System.out.println("File created: " + hello.getName());
            } else{
                System.out.printf("File %s already exists.", hello.getName());
            }
        } catch (IOException e) {
            System.out.println("File can't be created.");
            e.printStackTrace();
        }
    }
}

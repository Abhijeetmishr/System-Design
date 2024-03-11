package Java.Core.serialization;
import java.io.*;

public class Serialize {
    public static void main(String[] args){
        try {
            Student student = new Student("Abhijeet", "abc@gmail.com", 12345, "Delhi");
            FileOutputStream fileOutputStream = new FileOutputStream("ob.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

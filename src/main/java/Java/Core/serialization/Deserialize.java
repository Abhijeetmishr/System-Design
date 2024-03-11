package Java.Core.serialization;
import java.io.*;

public class Deserialize {
    public static void main(String[] args){
        try {
            FileInputStream fileInputStream = new FileInputStream("ob.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student.getName());
            objectInputStream.close();
            fileInputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){    
            System.out.println(e.getMessage());
        } 
    }
}

package Java.Core.InterfaceStaticMethod;

public class FileLogger implements Logger{
    
    @Override
    public void log(String message){
        System.out.println("" + message);
    }
}

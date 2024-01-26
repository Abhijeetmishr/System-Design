package Java.Core.InterfaceStaticMethod;

public interface Logger {
    void log(String message);

    //static method for default Logger
    static Logger getDefaultLogger(){
        return new ConsoleLogger();
    }

    // Static method for logging an error message
    static void logError(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }
}

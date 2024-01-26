package Java.Core.InterfaceStaticMethod;

public class Main {
    public static void main(String[] args) {
        // Using instance method
        Logger consoleLogger = new ConsoleLogger();
        consoleLogger.log("This message will be logged to the console.");

        // Using static method to obtain a default logger
        Logger defaultLogger = Logger.getDefaultLogger();
        defaultLogger.log("This message will be logged using the default logger.");

        // Using static method to log an error message
        Logger.logError("This is an error message.");

        // Using a different logger implementation
        // Logger fileLogger = new FileLogger("/path/to/log.txt");
        // fileLogger.log("This message will be logged to a file.");

        /*
         * In this example, the Logger interface defines an instance method log for logging messages and two static methods. The static method getDefaultLogger provides a default logger implementation (in this case, ConsoleLogger), and the static method logError logs error messages to the standard error stream.

Classes implementing the Logger interface, such as ConsoleLogger and FileLogger, provide their own implementations for the instance method log. The static methods can be called directly on the interface, allowing easy access to utility methods without the need to create an instance of a specific logger class.

This approach promotes code reuse and provides a convenient way to access common functionality related to logging across different classes.
         */
    }
}

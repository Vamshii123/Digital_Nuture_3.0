// SingletonPatternExample.java

// Logger.java - Singleton Class
public class Logger {
    // Private static instance of the Logger class
    private static Logger instance;

    // Private constructor to prevent instantiation
    private Logger() {
        // Initialization code (e.g., setting up log file, etc.)
    }

    // Public static method to provide access to the single instance
    public static Logger getInstance() {
        // Double-checked locking for thread safety
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log messages
    public void log(String message) {
        // Logging logic (e.g., print to console, write to file, etc.)
        System.out.println("Log: " + message);
    }
}

// TestSingletonPattern.java - Test Class
public class SingletonPatternExample {
    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log some messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Verify that both logger1 and logger2 are the same instance
        System.out.println("logger1 and logger2 are the same instance: " + (logger1 == logger2));
    }
}
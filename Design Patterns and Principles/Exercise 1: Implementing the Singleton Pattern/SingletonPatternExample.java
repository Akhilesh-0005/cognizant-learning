import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// ── Singleton Class ──
class Logger {
    private static volatile Logger instance = null;

    private Logger() {
        System.out.println("Logger instance created! (only once)\n");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String level, String message) {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.printf("[%s] [%-5s] %s%n", time, level, message);
    }
}

// ── Test Class ──
public class SingletonPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern — Logger Demo ===\n");

        Logger loggerA = Logger.getInstance();
        Logger loggerB = Logger.getInstance();
        Logger loggerC = Logger.getInstance();

        System.out.println("--- Reference Equality ---");
        System.out.println("loggerA == loggerB : " + (loggerA == loggerB));
        System.out.println("loggerB == loggerC : " + (loggerB == loggerC));

        System.out.println("\n--- Hash Codes ---");
        System.out.println("hashCode A : " + loggerA.hashCode());
        System.out.println("hashCode B : " + loggerB.hashCode());
        System.out.println("hashCode C : " + loggerC.hashCode());

        System.out.println("\n--- Logging ---");
        loggerA.log("INFO",  "Application started");
        loggerB.log("WARN",  "Low memory warning");
        loggerC.log("ERROR", "Null pointer exception caught");

        System.out.println("\nSUCCESS: All instances are the same object.");
    }
}

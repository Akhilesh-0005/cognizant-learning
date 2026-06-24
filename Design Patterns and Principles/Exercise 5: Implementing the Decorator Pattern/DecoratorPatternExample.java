// ── Component Interface ──
interface Notifier {
    void send(String message);
}

// ── Concrete Component ──
class EmailNotifier implements Notifier {
    private final String email;
    public EmailNotifier(String email) { this.email = email; }
    public void send(String message) {
        System.out.println("Email to " + email + ": " + message);
    }
}

// ── Abstract Decorator ──
abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;
    public NotifierDecorator(Notifier notifier) { this.wrappee = notifier; }
    public void send(String message)            { wrappee.send(message); }
}

// ── Concrete Decorators ──
class SMSNotifierDecorator extends NotifierDecorator {
    private final String phone;
    public SMSNotifierDecorator(Notifier notifier, String phone) {
        super(notifier);
        this.phone = phone;
    }
    public void send(String message) {
        super.send(message);
        System.out.println("SMS to " + phone + ": " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    private final String channel;
    public SlackNotifierDecorator(Notifier notifier, String channel) {
        super(notifier);
        this.channel = channel;
    }
    public void send(String message) {
        super.send(message);
        System.out.println("Slack [" + channel + "]: " + message);
    }
}

// ── Test Class ──
public class DecoratorPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern — Notification System ===\n");

        // Email only
        Notifier emailOnly = new EmailNotifier("user@example.com");
        System.out.println("-- Email only --");
        emailOnly.send("Server is down!");

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(
                new EmailNotifier("user@example.com"), "+91-9876543210");
        System.out.println("\n-- Email + SMS --");
        emailAndSMS.send("Disk usage above 90%!");

        // Email + SMS + Slack
        Notifier allChannels = new SlackNotifierDecorator(
                new SMSNotifierDecorator(
                        new EmailNotifier("user@example.com"), "+91-9876543210"),
                "#alerts");
        System.out.println("\n-- Email + SMS + Slack --");
        allChannels.send("Critical: Database connection lost!");

        System.out.println("\nDecorator Pattern implemented successfully.");
    }
}

// ── Strategy Interface ──
interface PaymentStrategy {
    void pay(double amount);
}

// ── Concrete Strategies ──
class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String holderName;

    public CreditCardPayment(String cardNumber, String holderName) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
    }

    public void pay(double amount) {
        System.out.printf("Paid $%.2f using Credit Card [%s] — Holder: %s%n",
                amount, cardNumber, holderName);
    }
}

class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) { this.email = email; }

    public void pay(double amount) {
        System.out.printf("Paid $%.2f via PayPal account: %s%n", amount, email);
    }
}

class UPIPayment implements PaymentStrategy {
    private final String upiId;

    public UPIPayment(String upiId) { this.upiId = upiId; }

    public void pay(double amount) {
        System.out.printf("Paid $%.2f via UPI ID: %s%n", amount, upiId);
    }
}

// ── Context Class ──
class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) throw new IllegalStateException("Payment strategy not set.");
        strategy.pay(amount);
    }
}

// ── Test Class ──
public class StrategyPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern — Payment System ===\n");

        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment("4111-1111-1111-1111", "Akhilesh Kumar"));
        context.executePayment(1500.00);

        context.setStrategy(new PayPalPayment("akhilesh@example.com"));
        context.executePayment(750.00);

        context.setStrategy(new UPIPayment("akhilesh@upi"));
        context.executePayment(250.00);

        System.out.println("\nStrategy Pattern implemented successfully.");
    }
}

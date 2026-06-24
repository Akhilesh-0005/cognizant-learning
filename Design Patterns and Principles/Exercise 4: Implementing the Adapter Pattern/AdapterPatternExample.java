// ── Target Interface ──
interface PaymentProcessor {
    void processPayment(double amount);
}

// ── Adaptee Classes (third-party gateways) ──
class PayPalGateway {
    public void makePayPalPayment(double amount) {
        System.out.printf("PayPal: Processing payment of $%.2f%n", amount);
    }
}

class StripeGateway {
    public void chargeStripe(double amount) {
        System.out.printf("Stripe: Charging $%.2f to card%n", amount);
    }
}

class RazorpayGateway {
    public void payViaRazorpay(double amount) {
        System.out.printf("Razorpay: Payment of $%.2f initiated%n", amount);
    }
}

// ── Adapter Classes ──
class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPal;
    public PayPalAdapter(PayPalGateway payPal) { this.payPal = payPal; }
    public void processPayment(double amount)  { payPal.makePayPalPayment(amount); }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripe;
    public StripeAdapter(StripeGateway stripe) { this.stripe = stripe; }
    public void processPayment(double amount)  { stripe.chargeStripe(amount); }
}

class RazorpayAdapter implements PaymentProcessor {
    private final RazorpayGateway razorpay;
    public RazorpayAdapter(RazorpayGateway razorpay) { this.razorpay = razorpay; }
    public void processPayment(double amount)         { razorpay.payViaRazorpay(amount); }
}

// ── Test Class ──
public class AdapterPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern — Payment Processing ===\n");

        PaymentProcessor paypal   = new PayPalAdapter(new PayPalGateway());
        PaymentProcessor stripe   = new StripeAdapter(new StripeGateway());
        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());

        paypal.processPayment(150.00);
        stripe.processPayment(250.00);
        razorpay.processPayment(350.00);

        System.out.println("\nAdapter Pattern implemented successfully.");
    }
}

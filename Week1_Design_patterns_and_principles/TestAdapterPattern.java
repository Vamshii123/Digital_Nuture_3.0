// PaymentProcessor.java - Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// PaymentGatewayA.java - Adaptee Class 1
class PaymentGatewayA {
    public void doPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via Payment Gateway A");
        // Actual logic specific to Payment Gateway A
    }
}

// PaymentGatewayB.java - Adaptee Class 2
class PaymentGatewayB {
    public void executePayment(double amount) {
        System.out.println("Executing payment of $" + amount + " via Payment Gateway B");
        // Actual logic specific to Payment Gateway B
    }
}

// PaymentGatewayAAdapter.java - Adapter for Payment Gateway A
class PaymentGatewayAAdapter implements PaymentProcessor {
    private PaymentGatewayA gatewayA;

    public PaymentGatewayAAdapter(PaymentGatewayA gatewayA) {
        this.gatewayA = gatewayA;
    }

    @Override
    public void processPayment(double amount) {
        gatewayA.doPayment(amount);
    }
}

// PaymentGatewayBAdapter.java - Adapter for Payment Gateway B
class PaymentGatewayBAdapter implements PaymentProcessor {
    private PaymentGatewayB gatewayB;

    public PaymentGatewayBAdapter(PaymentGatewayB gatewayB) {
        this.gatewayB = gatewayB;
    }

    @Override
    public void processPayment(double amount) {
        gatewayB.executePayment(amount);
    }
}

// TestAdapterPattern.java - Test Class
public class TestAdapterPattern {
    public static void main(String[] args) {
        // Using Payment Gateway A via its adapter
        PaymentGatewayA gatewayA = new PaymentGatewayA();
        PaymentProcessor adapterA = new PaymentGatewayAAdapter(gatewayA);
        adapterA.processPayment(100.0);

        System.out.println("---");

        // Using Payment Gateway B via its adapter
        PaymentGatewayB gatewayB = new PaymentGatewayB();
        PaymentProcessor adapterB = new PaymentGatewayBAdapter(gatewayB);
        adapterB.processPayment(150.0);
    }
}
// File: StrategyPatternExample.java

public class StrategyPatternExample {

    public static void main(String[] args) {
        // Create different payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "John Doe");
        PaymentStrategy paypalPayment = new PayPalPayment("john.doe@example.com");

        // Create payment context with CreditCardPayment
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.executePayment(100);

        // Create payment context with PayPalPayment
        paymentContext = new PaymentContext(paypalPayment);
        paymentContext.executePayment(200);
    }

    // Strategy Interface
    interface PaymentStrategy {
        void pay(int amount);
    }

    // Concrete Strategy for Credit Card Payment
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String cardHolderName;

        public CreditCardPayment(String cardNumber, String cardHolderName) {
            this.cardNumber = cardNumber;
            this.cardHolderName = cardHolderName;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
            System.out.println("Card Number: " + cardNumber);
            System.out.println("Card Holder: " + cardHolderName);
        }
    }

    // Concrete Strategy for PayPal Payment
    static class PayPalPayment implements PaymentStrategy {
        private String email;

        public PayPalPayment(String email) {
            this.email = email;
        }

        @Override
        public void pay(int amount) {
            System.out.println("Paid " + amount + " using PayPal.");
            System.out.println("Email: " + email);
        }
    }

    // Context Class
    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public PaymentContext(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(int amount) {
            paymentStrategy.pay(amount);
        }
    }
}
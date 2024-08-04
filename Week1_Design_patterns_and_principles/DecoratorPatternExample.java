// Notifier.java - Component Interface
interface Notifier {
    void send(String message);
}

// EmailNotifier.java - Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
        // Actual logic to send email notification
    }
}

// NotifierDecorator.java - Abstract Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// SMSNotifierDecorator.java - Concrete Decorator
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS notification: " + message);
        // Additional logic for sending SMS notification
    }
}

// SlackNotifierDecorator.java - Concrete Decorator
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack notification: " + message);
        // Additional logic for sending Slack notification
    }
}

// TestDecoratorPattern.java - Test Class
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a base notifier (EmailNotifier)
        Notifier baseNotifier = new EmailNotifier();

        // Decorate with SMS notification
        Notifier smsDecorator = new SMSNotifierDecorator(baseNotifier);
        smsDecorator.send("Important message via SMS");

        System.out.println("---");

        // Decorate with Slack notification
        Notifier slackDecorator = new SlackNotifierDecorator(baseNotifier);
        slackDecorator.send("Urgent message via Slack");

        System.out.println("---");

        // Decorate with both SMS and Slack notifications
        Notifier smsAndSlackDecorator = new SlackNotifierDecorator(new SMSNotifierDecorator(baseNotifier));
        smsAndSlackDecorator.send("Critical message via SMS and Slack");
    }
}
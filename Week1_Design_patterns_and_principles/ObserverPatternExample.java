import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Define Subject Interface
interface Stock {
    void register(Observer observer);
    void deregister(Observer observer);
    void notifyObservers(BigDecimal price);
}

// Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private BigDecimal price;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(BigDecimal price) {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    // Method to simulate price change and notify observers
    public void setPrice(BigDecimal price) {
        this.price = price;
        notifyObservers(price);
    }
}

// Define Observer Interface
interface Observer {
    void update(BigDecimal price);
}

// Implement Concrete Observer: MobileApp
class MobileApp implements Observer {
    @Override
    public void update(BigDecimal price) {
        System.out.println("Mobile App: Price updated to " + price);
        // Implement actual update logic for mobile app here
    }
}

// Implement Concrete Observer: WebApp
class WebApp implements Observer {
    @Override
    public void update(BigDecimal price) {
        System.out.println("Web App: Price updated to " + price);
        // Implement actual update logic for web app here
    }
}

// Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create subject (StockMarket)
        StockMarket stockMarket = new StockMarket();

        // Create observers (MobileApp and WebApp)
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        // Simulate stock price changes
        stockMarket.setPrice(new BigDecimal("100.00"));
        stockMarket.setPrice(new BigDecimal("105.00"));

        // Deregister an observer (e.g., web app)
        stockMarket.deregister(webApp);

        // Simulate another stock price change
        stockMarket.setPrice(new BigDecimal("110.00"));
    }
}
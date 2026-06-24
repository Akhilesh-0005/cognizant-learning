import java.util.ArrayList;
import java.util.List;

// ── Observer Interface ──
interface Observer {
    void update(String stockName, double price);
}

// ── Subject Interface ──
interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

// ── Concrete Subject ──
class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStockPrice(String name, double price) {
        this.stockName = name;
        this.price     = price;
        System.out.printf("%nStock Update: %s = $%.2f%n", name, price);
        notifyObservers();
    }

    public void registerObserver(Observer o)   { observers.add(o); }
    public void deregisterObserver(Observer o) { observers.remove(o); }
    public void notifyObservers() {
        for (Observer o : observers) o.update(stockName, price);
    }
}

// ── Concrete Observers ──
class MobileApp implements Observer {
    private final String user;
    public MobileApp(String user) { this.user = user; }
    public void update(String stock, double price) {
        System.out.printf("  [MobileApp - %s] Alert: %s is now $%.2f%n", user, stock, price);
    }
}

class WebApp implements Observer {
    private final String portal;
    public WebApp(String portal) { this.portal = portal; }
    public void update(String stock, double price) {
        System.out.printf("  [WebApp - %s] Dashboard updated: %s = $%.2f%n", portal, stock, price);
    }
}

// ── Test Class ──
public class ObserverPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern — Stock Market Monitor ===");

        StockMarket market = new StockMarket();

        Observer mobile1 = new MobileApp("Akhilesh");
        Observer mobile2 = new MobileApp("Rahul");
        Observer web1    = new WebApp("NSE Portal");

        market.registerObserver(mobile1);
        market.registerObserver(mobile2);
        market.registerObserver(web1);

        market.setStockPrice("TCS",    3850.50);
        market.setStockPrice("INFOSYS", 1520.75);

        System.out.println("\n[Rahul unsubscribes]");
        market.deregisterObserver(mobile2);

        market.setStockPrice("WIPRO", 430.20);

        System.out.println("\nObserver Pattern implemented successfully.");
    }
}

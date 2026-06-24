// ── Subject Interface ──
interface Image {
    void display();
}

// ── Real Subject ──
class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from remote server: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// ── Proxy Class ──
class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage = null;   // lazy — not loaded until first display()

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            System.out.println("[Proxy] Cache miss — fetching real image...");
            realImage = new RealImage(filename);   // lazy init
        } else {
            System.out.println("[Proxy] Cache hit — serving from cache.");
        }
        realImage.display();
    }
}

// ── Test Class ──
public class ProxyPatternExample {
    public static void main(String[] args) {
        System.out.println("=== Proxy Pattern — Image Viewer ===\n");

        Image image1 = new ProxyImage("photo_vacation.jpg");
        Image image2 = new ProxyImage("photo_office.jpg");

        System.out.println("-- First call (loads from server) --");
        image1.display();

        System.out.println("\n-- Second call (served from cache) --");
        image1.display();

        System.out.println("\n-- Different image (loads from server) --");
        image2.display();

        System.out.println("\nProxy Pattern implemented successfully.");
    }
}

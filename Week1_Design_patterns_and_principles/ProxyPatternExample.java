// Image.java - Subject Interface
public interface Image {
    void display();
}

// RealImage.java - Real Subject Class
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image " + filename + " from server...");
        // Simulate loading image from remote server
    }

    @Override
    public void display() {
        System.out.println("Displaying image " + filename);
        // Actual display logic
    }
}

// ProxyImage.java - Proxy Class
public class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// TestProxyPattern.java - Test Class
public class ProxyPatternExample {
    public static void main(String[] args) {
        // Create a proxy image (lazy initialization and caching)
        Image image1 = new ProxyImage("image1.jpg");

        // Image will be loaded from server only when needed
        image1.display();
        System.out.println("---");

        // Image will be loaded from cache
        image1.display();
        System.out.println("---");

        // Create another proxy image
        Image image2 = new ProxyImage("image2.png");

        // Image will be loaded from server only when needed
        image2.display();
    }
}
import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class InventoryManagementSystem {
    private Map<Integer, Product> products;

    public InventoryManagementSystem() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product ID already exists.");
        }
        products.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, String newName, Integer newQuantity, Double newPrice) {
        Product product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product ID does not exist.");
        }
        if (newName != null) {
            product.setProductName(newName);
        }
        if (newQuantity != null) {
            product.setQuantity(newQuantity);
        }
        if (newPrice != null) {
            product.setPrice(newPrice);
        }
    }

    public void deleteProduct(int productId) {
        if (!products.containsKey(productId)) {
            throw new IllegalArgumentException("Product ID does not exist.");
        }
        products.remove(productId);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        
        // Adding a product
        Product p1 = new Product(1, "Product A", 10, 99.99);
        inventory.addProduct(p1);
        System.out.println("After adding Product A:");
        System.out.println(inventory.getProduct(1));
        
        // Updating the product
        inventory.updateProduct(1, null, 20, null);
        System.out.println("After updating Product A's quantity to 20:");
        System.out.println(inventory.getProduct(1));
        
        // Deleting the product
        inventory.deleteProduct(1);
        System.out.println("After deleting Product A:");
        System.out.println(inventory.getProduct(1));
    }
}

package Product;

public abstract class Product {

    private final String productId;
    private final String name;
    final double basePrice;

    public Product(String productId, String name, double basePrice) {
        this.productId = productId;
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double calculatePrice();
}

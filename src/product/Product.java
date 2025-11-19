package product;

public abstract class Product implements Shippable {

    private final String productId;
    private final String name;
    private final double basePrice;
    private final double weight;

    public Product(String productId, String name, double basePrice, double weight) {
        this.productId = productId;
        this.name = name;
        this.basePrice = basePrice;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public abstract double calculatePrice();
}

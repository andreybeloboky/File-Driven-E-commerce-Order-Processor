package product;

public abstract class Product implements Shippable {

    final String productId;
    final String name;
    final double basePrice;
    final double weight;

    public Product(String productId, String name, double basePrice, double weight) {
        this.productId = productId;
        this.name = name;
        this.basePrice = basePrice;
        this.weight = weight;
    }

    public abstract double calculatePrice();
}

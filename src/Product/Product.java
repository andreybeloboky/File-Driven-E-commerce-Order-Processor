public abstract class Product {

    private final int productId;
    private final String name;
    final double basePrice;

    public Product(int productId, String name, double basePrice) {
        this.productId = productId;
        this.name = name;
        this.basePrice = basePrice;
    }

    public abstract double calculatePrice();
}

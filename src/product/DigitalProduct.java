package product;

public class DigitalProduct extends Product {

    public DigitalProduct(String productId, String name, double basePrice, double weight) {
        super(productId, name, basePrice, weight);
    }

    @Override
    public double calculatePrice() {
        return basePrice;
    }

    @Override
    public double getShippingWeight() {
        return weight;
    }
}

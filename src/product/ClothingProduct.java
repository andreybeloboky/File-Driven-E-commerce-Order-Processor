package product;

public class ClothingProduct extends Product implements Shippable {

    public ClothingProduct(String productId, String name, double basePrice, double weight) {
        super(productId, name, basePrice, weight);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice();
    }

    @Override
    public double getShippingWeight() {
        return getWeight();
    }
}

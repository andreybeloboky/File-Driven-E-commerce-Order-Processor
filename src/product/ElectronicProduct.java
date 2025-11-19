package product;

public class ElectronicProduct extends Product implements Shippable {

    private static final Double CONSTANT_INDEX = 1.1;

    public ElectronicProduct(String productId, String name, double basePrice, double weight) {
        super(productId, name, basePrice, weight);
    }

    @Override
    public double calculatePrice() {
        return getBasePrice() * CONSTANT_INDEX;
    }

    @Override
    public double getShippingWeight() {
        return getWeight();
    }
}

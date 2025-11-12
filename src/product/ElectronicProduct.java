package product;

public class ElectronicProduct extends Product implements Shippable {

    public ElectronicProduct(String productId, String name, double basePrice, double weight) {
        super(productId, name, basePrice, weight);
    }

    @Override
    public double calculatePrice() {
        return basePrice * 1.1;
    }

    @Override
    public double getShippingWeight() {
        return weight;
    }
}

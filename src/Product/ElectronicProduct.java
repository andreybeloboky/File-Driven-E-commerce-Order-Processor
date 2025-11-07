public class ElectronicProduct extends Product implements Shippable {

    public ElectronicProduct(int productId, String name, double basePrice) {
        super(productId, name, basePrice);
    }

    @Override
    public double getShippingWeight() {
        return 0;
    }

    @Override
    public double calculatePrice() {
        return basePrice * 1.1;
    }
}

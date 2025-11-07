public class ClothingProduct extends Product implements Shippable{

    public ClothingProduct(int productId, String name, double basePrice) {
        super(productId, name, basePrice);
    }

    @Override
    public double calculatePrice() {
        return basePrice;
    }

    @Override
    public double getShippingWeight() {
        return 0;
    }
}

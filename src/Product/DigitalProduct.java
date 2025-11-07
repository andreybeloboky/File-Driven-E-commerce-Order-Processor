public class DigitalProduct extends Product{


    public DigitalProduct(int productId, String name, double basePrice) {
        super(productId, name, basePrice);
    }

    @Override
    public double calculatePrice() {
        return basePrice;
    }
}

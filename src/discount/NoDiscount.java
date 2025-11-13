package discount;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double subtotal) {
        return subtotal;
    }

    @Override
    public double getValue() {
        return 0;
    }

}

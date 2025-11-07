package Strategy;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double subtotal) {
        return subtotal;
    }
}

public class FixedAmountDiscount implements DiscountStrategy {
    private final double discountAmount;

    public FixedAmountDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double applyDiscount(double subtotal) {
        return Math.max(0, subtotal - discountAmount);
    }
}

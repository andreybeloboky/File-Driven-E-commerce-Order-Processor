package strategy;

public record FixedAmountDiscount(double discountAmount) implements DiscountStrategy {

    @Override
    public double applyDiscount(double subtotal) {
        return Math.max(0, subtotal - discountAmount);
    }

}

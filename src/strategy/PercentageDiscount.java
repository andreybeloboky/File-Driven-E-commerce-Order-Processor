package strategy;

public record PercentageDiscount(double percentage) implements DiscountStrategy {

    @Override
    public double applyDiscount(double subtotal) {
        return subtotal * (100 - percentage) / 100;
    }
}

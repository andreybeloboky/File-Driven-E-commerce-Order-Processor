public class PercentageDiscount implements DiscountStrategy{
    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double subtotal) {
        return subtotal*(100-percentage)/100;
    }
}

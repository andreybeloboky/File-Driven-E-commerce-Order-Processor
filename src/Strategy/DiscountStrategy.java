package Strategy;

public interface DiscountStrategy {
    double applyDiscount (double subtotal);
    double getPercentage();
}

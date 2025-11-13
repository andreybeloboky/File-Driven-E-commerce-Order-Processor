package discount;

public interface DiscountStrategy {

    double applyDiscount(double subtotal);

    double getValue();

}

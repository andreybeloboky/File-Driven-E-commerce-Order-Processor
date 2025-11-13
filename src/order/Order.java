package order;

import product.Product;
import discount.DiscountStrategy;

import java.util.LinkedList;
import java.util.List;

public class Order {

    private final List<Product> products;
    private final DiscountStrategy discountStrategy;
    private final double subtotalWithoutDiscount;
    private final double totalWeight;

    public Order(List<Product> products, DiscountStrategy discountStrategy) {
        this.products = products;
        this.discountStrategy = discountStrategy;
        this.subtotalWithoutDiscount = calculateSubtotalWithoutDiscount(products);
        this.totalWeight = calculateTotalShippingWeight();
    }


    public double calculateTotalPrice() {
        return discountStrategy.applyDiscount(this.subtotalWithoutDiscount);
    }

    public double getSubtotalWithoutDiscount() {
        return this.subtotalWithoutDiscount;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    private double calculateTotalShippingWeight() {
        double totalWeight = 0;
        for (Product product : products) {
            totalWeight += product.getShippingWeight();
        }
        return totalWeight;
    }

    private double calculateSubtotalWithoutDiscount(List<Product> products) {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.calculatePrice();
        }
        return subtotal;
    }

}

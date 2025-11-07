package Controller;

import Product.Product;
import Strategy.DiscountStrategy;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private final List<Product> products = new LinkedList<>();
    private DiscountStrategy discountStrategy;

    void addProduct(List<Product> product) {
        products.addAll(product);
    }

    void setDiscountStrategy(DiscountStrategy strategy) {
        this.discountStrategy = strategy;
    }

    double calculateTotalPrice() {
        double subtotal = 0;
        for (Product product : products) {
            subtotal += product.calculatePrice();
        }
        return discountStrategy.applyDiscount(subtotal);
    }

    void calculateTotalShippingWeight() {

    }
}

package controller;

import discount.DiscountFactory;
import product.ProductFactory;
import order.Order;
import product.Product;
import discount.DiscountStrategy;
import discount.FixedAmountDiscount;
import discount.PercentageDiscount;

import java.nio.file.Path;
import java.util.List;


public class StoreController {

    public static final Path PRODUCT_FILE_PATH = Path.of("resources/products.csv");
    public static final Path DISCOUNT_FILE_PATH = Path.of("resources/active_discount.properties.csv");
    public static final String MESSAGE_PRODUCTS_LOADED = "Successfully loaded %s products from products.csv.\n";
    public static final String MESSAGE_PERCENTAGE_DISCOUNT_APPLIED = """
            Applying %s percentage discount from active_discount.properties.
            ---\s""";
    public static final String MESSAGE_AMOUNT_DISCOUNT_APPLIED = """
            Applying %s discount from active_discount.properties.
            ---\s""";
    public static final String MESSAGE_NO_DISCOUNT_APPLIED = """
            Applying no discount from active_discount.properties.
            ---\s""";
    public static final String MESSAGE_TOTAL_WEIGHT = "Total Shipping Weight: %s kg \n";
    public static final String MESSAGE_ORDER_SUBTOTAL = "Order Subtotal: %s$ \n";
    public static final String MESSAGE_FINAL_PRICE = "Final Price: %s$";

    public static void main(String[] args) {
        List<Product> products = ProductFactory.createProducts(PRODUCT_FILE_PATH);
        DiscountStrategy discountStrategy = DiscountFactory.createDiscountStrategy(DISCOUNT_FILE_PATH);
        Order order = new Order(products, discountStrategy);
        double totalPriceWithDiscount = order.calculateTotalPrice();
        double totalPriceWithoutDiscount = order.getSubtotalWithoutDiscount();
        System.out.printf(MESSAGE_PRODUCTS_LOADED, products.size());




        if (discountStrategy instanceof PercentageDiscount) {
            System.out.printf(MESSAGE_PERCENTAGE_DISCOUNT_APPLIED, discountStrategy.getValue());
        } else if (discountStrategy instanceof FixedAmountDiscount) {
            System.out.printf(MESSAGE_AMOUNT_DISCOUNT_APPLIED, discountStrategy.getValue());
        } else {
            System.out.printf(MESSAGE_NO_DISCOUNT_APPLIED);
        }
        System.out.printf(MESSAGE_TOTAL_WEIGHT, order.getTotalWeight());
        System.out.printf(MESSAGE_ORDER_SUBTOTAL, totalPriceWithoutDiscount);
        System.out.printf(MESSAGE_FINAL_PRICE, totalPriceWithDiscount);
    }
}


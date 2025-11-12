package controller;

import factory.DiscountFactory;
import factory.ProductFactory;
import product.Product;
import strategy.DiscountStrategy;
import strategy.FixedAmountDiscount;
import strategy.PercentageDiscount;

import java.nio.file.Path;
import java.util.List;


public class StoreDemo {

    public final static Path PRODUCT_CATALOG_FILE = Path.of("D:\\products.csv");
    public final static Path DISCOUNT_CONFIG_FILE = Path.of("D:\\active_discount.properties.txt");
    public final static String PRODUCTS_PRINT = "Successfully loaded %s products from products.csv.\n";
    public final static String PERCENTAGE_SET = """
            Applying %s percentage discount from active_discount.properties.
            ---\s
            """;
    public final static String AMOUNT_DISCOUNT = """
            Applying %s discount from active_discount.properties.
            ---\s
            """;
    public final static String NO_DISCOUNT = """
            Applying no discount from active_discount.properties.
            ---\s
            """;
    public final static String TOTAL_WEIGHT = "Total Shipping Weight: %s kg \n";
    public final static String ORDER = "Order Subtotal: %s$ \n";
    public final static String TOTAL_PRICE = "Final Price: %s$";


    public static void main(String[] args) {
        Order order = new Order();
        List<Product> products = ProductFactory.createProducts(PRODUCT_CATALOG_FILE);
        DiscountStrategy discountStrategy = DiscountFactory.careateDiscountStrategy(DISCOUNT_CONFIG_FILE);
        order.addProduct(products);
        order.setDiscountStrategy(discountStrategy);
        double totalPriceWithDiscount = order.calculateTotalPrice();
        double totalPriceWithoutDiscount = order.getSubtotalWithoutDiscount();
        System.out.printf(PRODUCTS_PRINT, products.size());
        if (discountStrategy instanceof PercentageDiscount getPercentage) {
            System.out.printf(PERCENTAGE_SET, getPercentage.percentage());
        } else if (discountStrategy instanceof FixedAmountDiscount getDiscountAmount) {
            System.out.printf(AMOUNT_DISCOUNT, getDiscountAmount.discountAmount());
        } else {
            System.out.printf(NO_DISCOUNT);
        }
        System.out.printf(TOTAL_WEIGHT, order.calculateTotalShippingWeight());
        System.out.printf(ORDER, totalPriceWithoutDiscount);
        System.out.printf(TOTAL_PRICE, totalPriceWithDiscount);
    }
}
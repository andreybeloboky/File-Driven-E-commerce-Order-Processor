package Controller;

import Factory.DiscountFactory;
import Factory.ProductFactory;
import Product.Product;
import Strategy.DiscountStrategy;

import java.nio.file.Path;
import java.util.List;


public class StoreDemo {

    public final static Path PRODUCT_CATALOG_FILE = Path.of("D:\\products.csv");
    public final static Path DISCOUNT_CONFIG_FILE = Path.of("D:\\active_discount.properties.txt");
    public final static String PRODUCTS_PRINT = "Successfully loaded %s products from products.csv.";
    public final static String PERCENTAGE_SET = "Applying %s percentage discount from active_discount.properties.\n" +
            "---";
    public final static String TOTAL_WEIGHT = "Total Shipping Weight: %s";
    public final static String ORDER = "Order Subtotal: %s";
    public final static String TOTAL_PRICE = "Final Price: %s";


    public static void main(String[] args) {
        Order order = new Order();
        List<Product> products = ProductFactory.createProducts(PRODUCT_CATALOG_FILE);
        DiscountStrategy discountStrategy = DiscountFactory.careateDiscountStrategy(DISCOUNT_CONFIG_FILE);
        order.addProduct(products);
        order.setDiscountStrategy(discountStrategy);
        System.out.printf(PRODUCTS_PRINT, products.size());
        System.out.printf(PERCENTAGE_SET, );
        System.out.printf(TOTAL_WEIGHT, order.calculateTotalShippingWeight());
        System.out.printf(ORDER, );
        System.out.printf(TOTAL_PRICE, order.calculateTotalPrice());
    }
}
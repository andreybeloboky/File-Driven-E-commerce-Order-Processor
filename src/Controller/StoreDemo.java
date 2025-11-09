package Controller;

import Factory.DiscountFactory;
import Factory.ProductFactory;
import Product.Product;
import Strategy.DiscountStrategy;

import java.nio.file.Path;
import java.util.List;


public class StoreDemo {

    public final static Path PRODUCT_CATALOG_FILE = Path.of("D:\\products.txt");
    public final static Path DISCOUNT_CONFIG_FILE = Path.of("D:\\active_discount.properties.txt");


    public static void main(String[] args) {
        Order order = new Order();
        List<Product> products = ProductFactory.createProducts(PRODUCT_CATALOG_FILE);
        DiscountStrategy discountStrategy = DiscountFactory.careateDiscountStrategy(DISCOUNT_CONFIG_FILE);
        order.addProduct(products);
        order.setDiscountStrategy(discountStrategy);
        double subtotal = order.calculateTotalPrice();
        System.out.println(subtotal);
        System.out.println(order.calculateTotalShippingWeight());
        System.out.println("Total");
    }
}
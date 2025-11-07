import Product.Product;
import Strategy.DiscountStrategy;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products;
    private DiscountStrategy discountStrategy;

    public Order(ArrayList<Product> products, DiscountStrategy discountStrategy) {
        this.products = products;
        this.discountStrategy = discountStrategy;
    }

    void addProduct(Product product){

    }

    void setDiscountStrategy(DiscountStrategy strategy){

    }

    void calculateTotalPrice(){

    }

    void calculateTotalShippingWeight(){

    }
}

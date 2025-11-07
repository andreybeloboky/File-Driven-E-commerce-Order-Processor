package Factory;

import Product.Product;
import Product.ElectronicProduct;
import Product.DigitalProduct;
import Product.ClothingProduct;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class ProductFactory {

    public static Product createProduct(String productString) {
        String[] args = productString.split(",");
        ProductTypes productTypes = ProductTypes.valueOf(args[0]);
        return switch (productTypes) {
            case ELECTRONIC -> new ElectronicProduct(args[1], args[0], Double.parseDouble(args[3]));
            case DIGITAL -> new DigitalProduct(args[1], args[0], Double.parseDouble(args[3]));
            case CLOTHING -> new ClothingProduct(args[1], args[0], Double.parseDouble(args[3]));
        };
    }

    public static List<Product> createProducts(Path path) {
        List<Product> products = new LinkedList<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                Product product = createProduct(line);
                products.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}

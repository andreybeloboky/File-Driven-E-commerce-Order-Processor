import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class StoreDemo {

    private final static PATH_PRODUCTS = "D:\\products.txt";


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\products.txt"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        String content = sb.toString();
        System.out.println(content);

        ProductFactory productFactory = new ProductFactory();
    }
}
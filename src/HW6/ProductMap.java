package HW6;

import java.util.HashMap;
import java.util.Map;

public class ProductMap {
    private static Map<Integer, Product> productMap = new HashMap<>();

    public static Product getProduct(int id) {
        return productMap.get(id);
    }

    public static void addProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    public static void deleteProduct(int id) {
        productMap.remove(id);
    }
}

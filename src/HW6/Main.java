package HW6;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProductOperations productMapper = new ProductOperations(DatabaseConnection.getConnection());
        List<Product> products = productMapper.findAll();
        products.forEach(p -> System.out.println(p.toString()));

        Product product = productMapper.findById(2);
        if (product != null) {
            System.out.println(product);
        }
    }
}

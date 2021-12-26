package HW6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductOperations {
    private final Connection connection;

    public ProductOperations(Connection connection) {
        this.connection = connection;
    }

    public Product findById(int id) throws SQLException {
        Product product = ProductMap.getProduct(id);
        if (product != null) {
            return product;
        } else {
            PreparedStatement statement = connection.prepareStatement(
                    "select id, title, price from products where id = ?");
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = new Product(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3));
                }
            }
            System.out.println("From database");
            return product;
        }
    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select id, title, price from products");
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
                products.add(product);
                ProductMap.addProduct(product);
            }
        }
        return products;
    }

    public void saveProduct(Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "insert into products (title, price) values (?, ?)");
            statement.setString(1, product.getTitle());
            statement.setInt(2, product.getPrice());
            statement.execute();
            ProductMap.addProduct(product);
        } catch (SQLException e) {
            throw new RuntimeException("Save error", e);
        }
    }

    public void deleteById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "delete from products where id = ?");
            statement.setLong(1, id);
            statement.execute();
            ProductMap.deleteProduct(id);
        } catch (SQLException e) {
            throw new RuntimeException("Delete error", e);
        }
    }
}

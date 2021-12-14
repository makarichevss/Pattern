package HW3;

import java.util.Objects;

public abstract class Product {
    private String name;
    private int price;

    public Product() {
    }

    public Product(Product product) {
        if (product != null){
            this.name = product.name;
            this.price = product.price;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Product product)) return false;
        return Objects.equals(product.name, name) && product.price == price;
    }

    public abstract Product clone();
}

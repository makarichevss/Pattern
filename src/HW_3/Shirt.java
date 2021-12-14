package HW_3;

import java.util.Objects;

public class Shirt extends Product {
    private int size;
    private String color;

    public Shirt() {
    }

    public Shirt(Shirt shirt){
        super(shirt);
        if (shirt != null){
            this.size = shirt.size;
            this.color = shirt.color;
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Shirt shirt) || !super.equals(obj)) return false;
        return shirt.size == size && Objects.equals(shirt.color, color);
    }

    @Override
    public Product clone() {
        return new Shirt(this);
    }
}

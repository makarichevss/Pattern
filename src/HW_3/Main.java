package HW_3;

public class Main {
    public static void main(String[] args) {

        Apple a1 = new Apple();
        a1.setName("Apple");
        a1.setPrice(50);
        a1.setSort("green");
        a1.setWeight(150);

        Shirt s1 = new Shirt();
        s1.setName("Shirt");
        s1.setPrice(700);
        s1.setSize(54);
        s1.setColor("black");

        Product a2 = a1.clone();
        Shirt s2 = (Shirt) s1.clone();

        if (a1.equals(a2)) {
            System.out.println("Different apples with the same content");
        }

        if (s1.equals(s2)) {
            System.out.println("Different shirts with the same content");
        }
    }
}

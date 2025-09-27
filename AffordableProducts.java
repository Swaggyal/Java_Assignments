import java.util.ArrayList;

class Product {
    String name;
    int price;

    // simple constructor
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class AffordableProducts {
    // returns an array of the products with price <= budget
    public static Product[] getAffordableProducts(Product[] products, int budget) {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < products.length; i++) {
            if (products[i].price <= budget) {
                list.add(products[i]);
            }
        }
        // convert back to array
        Product[] result = new Product[list.size()];
        return list.toArray(result);
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("Laptop", 1200),
            new Product("Phone", 800),
            new Product("Tablet", 600)
        };

        Product[] affordable = getAffordableProducts(products, 800);
        for (Product p : affordable) {
            System.out.println(p);
        }
        // Expected output:
        // Phone ($800)
        // Tablet ($600)
    }
}

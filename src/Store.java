import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    // 1. Add a product
    public void addProduct(Product product) {
        if (searchProductByReference(product.getReference()) != null) {
            System.out.println("A product with reference '" + product.getReference() + "' already exists.");
            return;
        }
        products.add(product);
        System.out.println("Product added successfully.");
    }

    // 2. Modify the quantity of a product in stock
    public boolean modifyProductQuantity(String reference, int newQuantity) {
        Product product = searchProductByReference(reference);
        if (product != null) {
            product.setQuantityInStock(newQuantity);
            return true;
        }
        return false;
    }

    // 3. Search for a product by its reference
    public Product searchProductByReference(String reference) {
        for (Product product : products) {
            if (product.getReference().equalsIgnoreCase(reference)) {
                return product;
            }
        }
        return null;
    }

    // 4. Display the list of products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available in the store.");
            return;
        }
        System.out.println("--- List of Products ---");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
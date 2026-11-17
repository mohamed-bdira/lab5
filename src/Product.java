public abstract class Product {
    private String reference;
    private String name;
    private double salesPriceExclTax;
    private int quantityInStock;
    private String description;

    // Constructor with description
    public Product(String reference, String name, double salesPriceExclTax, int quantityInStock, String description) {
        this.reference = reference;
        this.name = name;
        this.salesPriceExclTax = salesPriceExclTax;
        this.quantityInStock = quantityInStock;
        if (description == null || description.trim().isEmpty()) {
            this.description = "No description";
        } else {
            this.description = description;
        }
    }

    // Constructor without description (sets default value "No description")
    public Product(String reference, String name, double salesPriceExclTax, int quantityInStock) {
        this(reference, name, salesPriceExclTax, quantityInStock, "No description");
    }

    // Getters and Setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalesPriceExclTax() {
        return salesPriceExclTax;
    }

    public void setSalesPriceExclTax(double salesPriceExclTax) {
        this.salesPriceExclTax = salesPriceExclTax;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            this.description = "No description";
        } else {
            this.description = description;
        }
    }

    // Abstract method to calculate the sales price including tax
    public abstract double calculatePriceIncludingTax();

    @Override
    public String toString() {
        return "Reference: " + reference +
               " | Name: " + name +
               " | Price (excl. tax): " + salesPriceExclTax +
               " | Price (incl. tax): " + String.format("%.2f", calculatePriceIncludingTax()) +
               " | Quantity in stock: " + quantityInStock +
               " | Description: " + description;
    }
}
public class Microwave extends Product {
    private static final double VAT = 0.10; // 10%
    private String brand;
    private double trayDiameter;
    private double capacity;
    private int power;

    // Constructor with description
    public Microwave(String reference, String name, double salesPriceExclTax, int quantityInStock, String description,
                     String brand, double trayDiameter, double capacity, int power) {
        super(reference, name, salesPriceExclTax, quantityInStock, description);
        this.brand = brand;
        this.trayDiameter = trayDiameter;
        this.capacity = capacity;
        this.power = power;
    }

    // Constructor without description
    public Microwave(String reference, String name, double salesPriceExclTax, int quantityInStock,
                     String brand, double trayDiameter, double capacity, int power) {
        super(reference, name, salesPriceExclTax, quantityInStock);
        this.brand = brand;
        this.trayDiameter = trayDiameter;
        this.capacity = capacity;
        this.power = power;
    }

    // Getters and Setters
    public double getVat() {
        return VAT;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getTrayDiameter() {
        return trayDiameter;
    }

    public void setTrayDiameter(double trayDiameter) {
        this.trayDiameter = trayDiameter;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public double calculatePriceIncludingTax() {
        return getSalesPriceExclTax() * (1 + VAT);
    }

    @Override
    public String toString() {
        return "[Microwave] " + super.toString() +
               " | VAT: " + (VAT * 100) + "%" +
               " | Brand: " + brand +
               " | Tray Diameter: " + trayDiameter + " cm" +
               " | Capacity: " + capacity + " L" +
               " | Power: " + power + "W";
    }
}
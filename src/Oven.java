public class Oven extends Product {
    private static final double VAT = 0.05; // 5%
    private String brand;
    private int power;
    private int grillPower;
    private double minTemperature;
    private double maxTemperature;

    // Constructor with description
    public Oven(String reference, String name, double salesPriceExclTax, int quantityInStock, String description,
                String brand, int power, int grillPower, double minTemperature, double maxTemperature) {
        super(reference, name, salesPriceExclTax, quantityInStock, description);
        this.brand = brand;
        this.power = power;
        this.grillPower = grillPower;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    // Constructor without description
    public Oven(String reference, String name, double salesPriceExclTax, int quantityInStock,
                String brand, int power, int grillPower, double minTemperature, double maxTemperature) {
        super(reference, name, salesPriceExclTax, quantityInStock);
        this.brand = brand;
        this.power = power;
        this.grillPower = grillPower;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getGrillPower() {
        return grillPower;
    }

    public void setGrillPower(int grillPower) {
        this.grillPower = grillPower;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    @Override
    public double calculatePriceIncludingTax() {
        return getSalesPriceExclTax() * (1 + VAT);
    }

    @Override
    public String toString() {
        return "[Oven] " + super.toString() +
               " | VAT: " + (VAT * 100) + "%" +
               " | Brand: " + brand +
               " | Power: " + power + "W" +
               " | Grill Power: " + grillPower + "W" +
               " | Min Temp: " + minTemperature + "°C" +
               " | Max Temp: " + maxTemperature + "°C";
    }
}
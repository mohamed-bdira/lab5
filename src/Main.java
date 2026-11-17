import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = null;
        int choice;

        do {
            System.out.println("\n===== Household Appliance Store Menu =====");
            System.out.println("1. Create a store.");
            System.out.println("2. Add a product.");
            System.out.println("3. Modify the quantity of a product.");
            System.out.println("4. Display the list of products.");
            System.out.println("5. Search for a product by reference.");
            System.out.println("6. Exit the program.");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    store = new Store();
                    System.out.println("Store created successfully.");
                    break;

                case 2:
                    if (store == null) {
                        System.out.println("Please create a store first (Option 1).");
                        break;
                    }
                    System.out.println("Select product type:");
                    System.out.println("1. Oven");
                    System.out.println("2. Microwave");
                    System.out.print("Choice: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    if (type != 1 && type != 2) {
                        System.out.println("Invalid product type.");
                        break;
                    }

                    System.out.print("Enter reference: ");
                    String reference = scanner.nextLine();

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter sales price (excluding tax): ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter quantity in stock: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter description (press Enter to skip): ");
                    String description = scanner.nextLine();

                    System.out.print("Enter brand: ");
                    String brand = scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Enter power (in watts): ");
                        int power = scanner.nextInt();

                        System.out.print("Enter grill power (in watts): ");
                        int grillPower = scanner.nextInt();

                        System.out.print("Enter minimum temperature: ");
                        double minTemp = scanner.nextDouble();

                        System.out.print("Enter maximum temperature: ");
                        double maxTemp = scanner.nextDouble();
                        scanner.nextLine();

                        Oven oven;
                        if (description.trim().isEmpty()) {
                            oven = new Oven(reference, name, price, quantity, brand, power, grillPower, minTemp, maxTemp);
                        } else {
                            oven = new Oven(reference, name, price, quantity, description, brand, power, grillPower, minTemp, maxTemp);
                        }
                        store.addProduct(oven);
                    } else {
                        System.out.print("Enter tray diameter: ");
                        double trayDiameter = scanner.nextDouble();

                        System.out.print("Enter capacity (in liters): ");
                        double capacity = scanner.nextDouble();

                        System.out.print("Enter power (in watts): ");
                        int power = scanner.nextInt();
                        scanner.nextLine();

                        Microwave microwave;
                        if (description.trim().isEmpty()) {
                            microwave = new Microwave(reference, name, price, quantity, brand, trayDiameter, capacity, power);
                        } else {
                            microwave = new Microwave(reference, name, price, quantity, description, brand, trayDiameter, capacity, power);
                        }
                        store.addProduct(microwave);
                    }
                    break;

                case 3:
                    if (store == null) {
                        System.out.println("Please create a store first (Option 1).");
                        break;
                    }
                    System.out.print("Enter the reference of the product to modify: ");
                    String modRef = scanner.nextLine();

                    System.out.print("Enter the new quantity in stock: ");
                    int newQty = scanner.nextInt();
                    scanner.nextLine();

                    if (store.modifyProductQuantity(modRef, newQty)) {
                        System.out.println("Quantity updated successfully.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    if (store == null) {
                        System.out.println("Please create a store first (Option 1).");
                        break;
                    }
                    store.displayProducts();
                    break;

                case 5:
                    if (store == null) {
                        System.out.println("Please create a store first (Option 1).");
                        break;
                    }
                    System.out.print("Enter the reference of the product to search: ");
                    String searchRef = scanner.nextLine();

                    Product found = store.searchProductByReference(searchRef);
                    if (found != null) {
                        System.out.println("Product found: " + found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
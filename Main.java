import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctUsername = "Marco";
        String correctPassword = "5774";
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            StringBuilder password = new StringBuilder();
            for (int i = 0; i < correctPassword.length(); i++) {
                char ch = scanner.next().charAt(0);
                password.append(ch);
                System.out.print("*");
            }
            scanner.nextLine(); // clear buffer

            if (username.equals(correctUsername) && password.toString().equals(correctPassword)) {
                System.out.println("\n✅ Login successful! Welcome " + username + "!");
                break;
            } else {
                attempts--;
                System.out.println("\n❌ Incorrect credentials. Attempts left: " + attempts);
                if (attempts == 0) {
                    System.out.println("⚠ Access denied.");
                    return;
                }
            }
        }

        // Rental system demo
        RentalAgency agency = new RentalAgency();
        agency.addCar(new Car("KAA123", "Toyota Corolla"));
        agency.addCar(new Car("KBB456", "Honda Civic"));
        agency.addCustomer(new Customer("Alice", "C001"));
        agency.addCustomer(new Customer("Bob", "C002"));

        System.out.println("\nAvailable cars:");
        agency.showAvailableCars();

        System.out.println("\nRenting car KAA123 to customer C001...");
        agency.rentCar("KAA123", "C001");

        System.out.println("\nAvailable cars after rental:");
        agency.showAvailableCars();

        System.out.println("\nReturning car KAA123...");
        agency.returnCar("KAA123");

        System.out.println("\nAvailable cars after return:");
        agency.showAvailableCars();

        scanner.close();
    }
}
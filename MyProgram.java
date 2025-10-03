import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String correctUsername = "Marco";
        String correctPassword = "5774";

        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("\n✅ Login successful! Welcome " + username + "!");
                break;
            } else {
                attempts--;
                System.out.println("\n❌ Incorrect username or password.");
                if (attempts > 0) {
                    System.out.println("You have " + attempts + " attempt(s) left.");
                } else {
                    System.out.println("⚠ You have used all attempts. Access Denied!");
                }
            }
        }

        scanner.close();
    }
}
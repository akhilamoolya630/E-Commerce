import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Email {
    private String name;

    public Email(String name) {
        this.name = name;
    }

    public void importAmount() {
        String filePath = "D:\\customer_details\\" + name + "\\amount.txt";
        File file = new File(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void sendConfirmationEmail() {
        LocalDate currentDate = LocalDate.now();
        String message = "Order confirmed on " + currentDate + ".\nThank you for your order.\nRegards";

        System.out.println(message);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        Email email = new Email(userName);
        email.importAmount();
        email.sendConfirmationEmail();

        scanner.close();
    }
}

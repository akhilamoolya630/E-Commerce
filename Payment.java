package E_commerce_Application;

import java.io.*;
import java.util.Scanner;

public class Payment {
    private String name;
    private double totalAmount;
    private String paymentMethod;
    private String cardNumber;
    private String expirationDate;
    private String cvv;

    public Payment(String name, double totalAmount, String paymentMethod) {
        this.name = name;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    public Payment(String name, double totalAmount, String paymentMethod, String cardNumber, String expirationDate, String cvv) {
        this(name, totalAmount, paymentMethod);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void processPayment() {
        System.out.println("Processing payment of $" + totalAmount + " using " + paymentMethod);

        String fileName = "D://customer_details//" + name + "//amount.txt";
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            writer.println("Payment Details:");
            writer.println("Delivery charges: $30");
            writer.println("Total Amount: $" + totalAmount);
            writer.println("Payment Method: " + paymentMethod);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double readTotalPriceFromFile(String folderPath) {
        double totalPrice = 0.0;
        String fileName = folderPath + "//payment.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("total amount")) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        try {
                            // Remove any non-numeric characters from the total amount
                            totalPrice = Double.parseDouble(parts[1].replaceAll("[^0-9.]", ""));
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid total amount format: " + parts[1].trim());
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user's name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Read total price from file
        double totalAmount = readTotalPriceFromFile("D://customer_details//" + name);

        // Add delivery fee of $30
        totalAmount += 30.0;

        // Get payment method choice from the user
        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int choice = scanner.nextInt();

        Payment payment;
        if (choice == 1) {
            // Credit Card payment
            System.out.print("Enter credit card number: ");
            String cardNumber = scanner.next();
            System.out.print("Enter expiration date (MM/YY): ");
            String expirationDate = scanner.next();
            System.out.print("Enter CVV: ");
            String cvv = scanner.next();

            payment = new Payment(name, totalAmount, "Credit Card", cardNumber, expirationDate, cvv);
        } else if (choice == 2) {
            // Cash payment
            payment = new Payment(name, totalAmount, "Cash");
        } else {
            System.out.println("Invalid choice. Exiting.");
            return;
        }

        // Display payment details
        System.out.println("Payment Details:");
        System.out.println("Delivery charges: $30");
        System.out.println("Total Amount: $" + payment.getTotalAmount());
        System.out.println("Payment Method: " + payment.getPaymentMethod());

        // Process the payment
        payment.processPayment();

        scanner.close();
    }
}

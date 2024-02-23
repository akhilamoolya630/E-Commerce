package E_commerce_Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        scanner.close();

        String folderPath = "D://customer_details//" + name;
        String filePath = folderPath + "//cart.txt";

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Cart file not found for user " + name);
            return;
        }

        double totalAmount = 0.0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Cart contents for user " + name + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("Price:")) {
                    String priceString = line.split(":")[1].replace("$", "").trim();
                    double price = Double.parseDouble(priceString);
                    totalAmount += price;
                }
            }
            System.out.println("Total Amount: $" + totalAmount);

            String paymentFilePath = folderPath + "//payment.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(paymentFilePath))) {
                writer.write("Total Amount: $" + totalAmount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User_Profile {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println("Enter details for user " + i + " or type 'exit' to stop:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.print("Language: ");
            String lang = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();

            // Create a folder named "customer details" inside the D:// directory
            String parentFolder = "D://customer_details";
            File parentDirectory = new File(parentFolder);
            parentDirectory.mkdirs();

            // Check if the folder with the same name already exists
            String folderName = parentFolder + "//" + name;
            int count = 0;
            while (new File(folderName).exists()) {
                count++;
                folderName = parentFolder + "//" + name + count;
            }

            // Create a folder with the unique user name inside the "customer details" folder
            File folder = new File(folderName);
            folder.mkdirs();

            // Write user details to a file
            String fileName = folderName + "//user.txt";
            FileWriter fw = new FileWriter(fileName);
            fw.write("Name: " + name + "\n");
            fw.write("Language: " + lang + "\n");
            fw.write("Email: " + email + "\n");
            fw.write("Phone Number: " + phoneNumber + "\n");
            fw.write("Address: " + address + "\n");
            fw.close();

            System.out.println("User " + folder.getName() + "'s name is their identity throughout the ecommerce application.");
            System.out.println("It will be their login password in every step.");
        }
        scanner.close();
    }
}


package E_commerce_Application;

import java.io.File;

public class E_Commerce {

    public static void main(String[] args) {
        // Specify the directory path
        String directoryPath = "D://customer_details";

        // Create the directory
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory.");
            }
        } else {
            System.out.println("Directory already exists.");
        }
    }
}


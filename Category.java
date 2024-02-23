package E_commerce_Application;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Category {
    private FileWriter fileWriter;
    public Category(){
        fileWriter=null;
    }
    public static void main(String[] args) {
        Category category = new Category();
        category.selectCategory();
    }

    public void selectCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String folderPath = "D://customer_details//" + name;
        File folder = new File(folderPath);
        folder.mkdirs(); // Create customer's name folder

        String fileName = folderPath + "//cart.txt";
        try {
            fileWriter = new FileWriter(fileName, true); // Append mode
        } catch (IOException e) {
            e.printStackTrace();
        }    
        boolean continueShopping = true;
        while (continueShopping) {
            System.out.println("Categories:");
            System.out.println("1. Home Accessories");
            System.out.println("2. Electronics");
            System.out.println("3. Clothing");
            System.out.println("4. Beauty & Personal Care");
            System.out.println("5. Snacks");
            System.out.println("6. Toys & Games");
            System.out.println("7. Health & Wellness");
            System.out.println("8. Books & Stationery");
            System.out.println("9. Pet Supplies");
            System.out.print("Select a category (1-9) or enter 0 to stop shopping: ");
            int categoryChoice = scanner.nextInt();
            scanner.nextLine();

            if (categoryChoice == 0) {
                break; 
            } else if (categoryChoice < 1 || categoryChoice > 9) {
                System.out.println("Invalid choice");
                continue;
            }
            switch (categoryChoice) {
                case 1:
                    handleHomeAccessories(scanner);
                    break;
                case 2:
                    handleElectronics(scanner);
                    break;
                case 3:
                    handleClothing(scanner);
                    break;
                case 4:
                    handleBeautyPersonalCare(scanner);
                    break;
                case 5:
                    handleSnacks(scanner);
                    break;
                case 6:
                    handleToysGames(scanner);
                    break;
                case 7:
                    handleHealthWellness(scanner);
                    break;
                case 8:
                    handleBookhsStationery(scanner);
                    break;
                case 9:
                    handlePetSupplies(scanner);
                    break;
                default:
                    System.out.println("No subcategories available for this category");
                    break;
            }
            System.out.print("Do you want to continue shopping? (yes/no): ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("yes")) {
                continueShopping = false;
            }
        }
        scanner.close();
        try {
            if(fileWriter != null){
                 fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeToFile(String data) {
        try {
            if(fileWriter != null){
            fileWriter.write(data + "\n");
            fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void handleHomeAccessories(Scanner scanner) {
        boolean continueShopping = true;
        Random random = new Random();
        while (continueShopping) {
            System.out.println("Home Accessories Subcategories:");
            System.out.println("1. Kitchen & Dining");
            System.out.println("2. Home Decor");
            System.out.println("3. Furniture");
            System.out.println("4. Bedding & Bath");
            System.out.println("5. Storage & Organization");
            System.out.println("0. Return to category selection");

            System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
            int subCategoryChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (subCategoryChoice == 0) {
                break; // Return to category selection
            } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
                System.out.println("Invalid choice");
                continue;
            }
            
            double price = random.nextDouble() * 100 + 50;
            switch (subCategoryChoice) {
            case 1:
                writeToFile("Subcategory: Kitchen & Dining");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Subcategory: Home Decor");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Subcategory: Furniture");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Subcategory: Bedding & Bath");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Subcategory: Storage & Organization");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
private void handleElectronics(Scanner scanner) {
    boolean continueShopping = true;
    Random random = new Random();
    while (continueShopping) {
        System.out.println("Electronics Subcategories:");
        System.out.println("1. Smartphones and Smart Gadgets");
        System.out.println("2. Laptops & Computer Accessories");
        System.out.println("3. Camera & Video Equipments");
        System.out.println("4. Beauty Accessories");
        System.out.println("5. Home Appliances");
        System.out.println("0. Return to category selection");
        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }
        double price = random.nextDouble() * 1000 + 500; // Random price between $500 and $1500
        switch (subCategoryChoice) {
            case 1:
                writeToFile("Subcategory: Smartphones and Smart Gadgets");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Subcategory: Laptops & Computer Accessories");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Subcategory: Camera & Video Equipments");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Subcategory: Beauty Accessories");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Subcategory: Home Appliances");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
private void handleClothing(Scanner scanner) {
    Random random = new Random();
    while (true) {
        System.out.println("Clothing Subcategories:");
        System.out.println("1. Men's Clothing");
        System.out.println("2. Women's Clothing");
        System.out.println("3. Kids' Clothing");
        System.out.println("4. Shoes");
        System.out.println("5. Accessories");
        System.out.println("0. Return to category selection");

        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice;
        try {
            subCategoryChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Consume invalid input
            continue;
        }

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }

        double price = random.nextDouble() * 200 + 50; // Random price between $50 and $250
        switch (subCategoryChoice) {
            case 1:
                
                writeToFile("Subcategory: Men's Clothing");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                
                writeToFile("Subcategory: Women's Clothing");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Category: Clothing");
                writeToFile("Subcategory: Kids' Clothing");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                
                writeToFile("Subcategory: Shoes");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                
                writeToFile("Subcategory: Accessories");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

private void handleBeautyPersonalCare(Scanner scanner) {
    boolean continueShopping = true;
    Random random = new Random();
    while (continueShopping) {
        System.out.println("Beauty & Personal Care Subcategories:");
        System.out.println("1. Skincare");
        System.out.println("2. Haircare");
        System.out.println("3. Makeup");
        System.out.println("4. Fragrance");
        System.out.println("5. Personal Care Appliances");
        System.out.println("0. Return to category selection");

        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }

        double price = random.nextDouble() * 100 + 50;
        switch (subCategoryChoice) {
            case 1:
                writeToFile("Category: Beauty & Personal Care");
                writeToFile("Subcategory: Skincare");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Category: Beauty & Personal Care");
                writeToFile("Subcategory: Haircare");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Category: Beauty & Personal Care");
                writeToFile("Subcategory: Makeup");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Category: Beauty & Personal Care");
                writeToFile("Subcategory: Fragrance");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Category: Beauty & Personal Care");
                writeToFile("Subcategory: Personal Care Appliances");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
private void handleSnacks(Scanner scanner) {
    boolean continueShopping = true;
    Random random = new Random();
    while (continueShopping) {
        System.out.println("Snacks Subcategories:");
        System.out.println("1. Sweets and Mixes");
        System.out.println("2. Drinks");
        System.out.println("3. Sauces and Spreads");
        System.out.println("4. Gluten Free");
        System.out.println("5. Dry Fruits and Seeds");
        System.out.println("0. Return to category selection");

        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }

        double price = random.nextDouble() * 100 + 50;
        switch (subCategoryChoice) {
            case 1:
                writeToFile("Category: Snacks");
                writeToFile("Subcategory: Sweets and Mixes");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Category: Snacks");
                writeToFile("Subcategory: Drinks");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Category: Snacks");
                writeToFile("Subcategory: Sauces and Spreads");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Category: Snacks");
                writeToFile("Subcategory: Gluten Free");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Category: Snacks");
                writeToFile("Subcategory: Dry Fruits and Seeds");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

private void handleToysGames(Scanner scanner) {
    boolean continueShopping = true;
    Random random = new Random();
    while (continueShopping) {
        System.out.println("Toys & Games Subcategories:");
        System.out.println("1. Outdoor Toys");
        System.out.println("2. Board Games and Puzzles");
        System.out.println("3. Action Figures and Play Sets");
        System.out.println("4. Dolls and Accessories");
        System.out.println("5. Educational Toys");
        System.out.println("0. Return to category selection");

        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }

        double price = random.nextDouble() * 100 + 50;
        switch (subCategoryChoice) {
            case 1:
                writeToFile("Category: Toys & Games");
                writeToFile("Subcategory: Outdoor Toys");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Category: Toys & Games");
                writeToFile("Subcategory: Board Games and Puzzles");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Category: Toys & Games");
                writeToFile("Subcategory: Action Figures and Play Sets");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Category: Toys & Games");
                writeToFile("Subcategory: Dolls and Accessories");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Category: Toys & Games");
                writeToFile("Subcategory: Educational Toys");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

private void handleHealthWellness(Scanner scanner) {
    boolean continueShopping = true;
    Random random = new Random();
    while (continueShopping) {
        System.out.println("Health & Wellness Subcategories:");
        System.out.println("1. Vitamins and Supplements");
        System.out.println("2. Healthcare");
        System.out.println("3. Medical Devices and Equipment");
        System.out.println("4. Personal Care");
        System.out.println("5. Hygiene");
        System.out.println("0. Return to category selection");

        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }

        double price = random.nextDouble() * 100 + 50;
        switch (subCategoryChoice) {
            case 1:
                writeToFile("Category: Health & Wellness");
                writeToFile("Subcategory: Vitamins and Supplements");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Category: Health & Wellness");
                writeToFile("Subcategory: Healthcare");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Category: Health & Wellness");
                writeToFile("Subcategory: Medical Devices and Equipment");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Category: Health & Wellness");
                writeToFile("Subcategory: Personal Care");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Category: Health & Wellness");
                writeToFile("Subcategory: Hygiene");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

private void handleBookhsStationery(Scanner scanner) {
    boolean continueShopping = true;
    Random random = new Random();
    while (continueShopping) {
        System.out.println("Books & Stationery Subcategories:");
        System.out.println("1. Book Genre");
        System.out.println("2. Stationery Types");
        System.out.println("3. Education Materials");
        System.out.println("4. Art and Craft Supplies");
        System.out.println("5. Office Supplies");
        System.out.println("0. Return to category selection");

        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }

        double price = random.nextDouble() * 100 + 50;
        switch (subCategoryChoice) {
            case 1:
                writeToFile("Category: Books & Stationery");
                writeToFile("Subcategory: Book Genre");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Category: Books & Stationery");
                writeToFile("Subcategory: Stationery Types");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Category: Books & Stationery");
                writeToFile("Subcategory: Education Materials");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Category: Books & Stationery");
                writeToFile("Subcategory: Art and Craft Supplies");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Category: Books & Stationery");
                writeToFile("Subcategory: Office Supplies");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

private void handlePetSupplies(Scanner scanner) {
    boolean continueShopping = true;
    Random random = new Random();
    while (continueShopping) {
        System.out.println("Pet Supplies Subcategories:");
        System.out.println("1. Fish and Aquatic Supplies");
        System.out.println("2. Foods");
        System.out.println("3. Beds");
        System.out.println("4. Supplements");
        System.out.println("5. Toys");
        System.out.println("0. Return to category selection");

        System.out.print("Select a subcategory (1-5) or enter 0 to return to category selection: ");
        int subCategoryChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (subCategoryChoice == 0) {
            break; // Return to category selection
        } else if (subCategoryChoice < 1 || subCategoryChoice > 5) {
            System.out.println("Invalid choice");
            continue;
        }

        double price = random.nextDouble() * 100 + 50;
        switch (subCategoryChoice) {
            case 1:
                writeToFile("Category: Pet Supplies");
                writeToFile("Subcategory: Fish and Aquatic Supplies");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 2:
                writeToFile("Category: Pet Supplies");
                writeToFile("Subcategory: Foods");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 3:
                writeToFile("Category: Pet Supplies");
                writeToFile("Subcategory: Beds");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 4:
                writeToFile("Category: Pet Supplies");
                writeToFile("Subcategory: Supplements");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            case 5:
                writeToFile("Category: Pet Supplies");
                writeToFile("Subcategory: Toys");
                writeToFile("Price: $" + String.format("%.2f", price));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
}
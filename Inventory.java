/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    public class Inventory {
    private String name;
    private boolean availableInStock;

    public Inventory(String name, boolean availableInStock) {
        this.name = name;
        this.availableInStock = availableInStock;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailableInStock() {
        return availableInStock;
    }  


    public void setAvailableInStock(boolean availableInStock) {
        this.availableInStock = availableInStock;
    }

    public void checkAvailability() {
        if (availableInStock) {
            System.out.println(name + " is available in stock.");
        } else {
            System.out.println(name + " is not available in stock.");
        }
    }

    public static void main(String[] args) {
        Inventory product = new Inventory("Sample Product", false);
        product.checkAvailability();
    }

    private static class availableInStock {

        public availableInStock() {
        }
    }
}


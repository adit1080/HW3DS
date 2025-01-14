public class Main {
    public static void main(String[] args) {
        // יצירת מחסן
        StorageInventory inventory = new StorageInventory();

        // הוספת מוצרים
        Product product1 = new Product(1000, "Chocolate");
        Product product2 = new Product(1001, "Ice cream");
        Product product3 = new Product(1002, "Pancake");
        Product product4 = new Product(1003, "Waffles");
        Product product5 = new Product(1004, "Spinach");

        inventory.addProduct(product1, 1000000);
        inventory.addProduct(product2, 2847390);
        inventory.addProduct(product3, 38490);
        inventory.addProduct(product4, 500000000);
        inventory.addProduct(product5, 4);

        // בדיקת מלאי
        System.out.println("Checking inventory for Chocolate: " + inventory.checkInventory(product1));
        System.out.println("Checking inventory for Spinach: " + inventory.checkInventory(product5));

        // הורדת כמות מהמלאי
        inventory.reduceInventory(product1, 20);
        System.out.println("Updated amount of Chocolate: " + inventory.checkInventory(product1));

        // מחיקת מוצר
        inventory.removeProduct(product5);
        System.out.println("Checking inventory for Spinach after removal: " + inventory.checkInventory(product5));

        // הדפסת כל המלאי
        System.out.println("Full inventory:");
        inventory.printInventory();
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // יצירת מחסן ומערכת ניהול הזמנות
        StorageInventory inventory = new StorageInventory();
        OrdersManagement ordersManagement = new OrdersManagement(inventory);

        // הוספת 10 מוצרים שונים למחסן
        Product product1 = new Product(1000, "Chocolate");
        Product product2 = new Product(1001, "Ice cream");
        Product product3 = new Product(1002, "Pancake");
        Product product4 = new Product(1003, "Waffles");
        Product product5 = new Product(1004, "Spinach");
        Product product6 = new Product(1005, "Pizza");
        Product product7 = new Product(1006, "Apple");
        Product product8 = new Product(1007, "Sushi");
        Product product9 = new Product(1008, "Strawberry");
        Product product10 = new Product(1009, "Pineapple");

        inventory.addProduct(product1, 1111);
        inventory.addProduct(product2, 555);
        inventory.addProduct(product3, 222);
        inventory.addProduct(product4, 333);
        inventory.addProduct(product5, 111);
        inventory.addProduct(product6, 444);
        inventory.addProduct(product7, 666);
        inventory.addProduct(product8, 777);
        inventory.addProduct(product9, 44);
        inventory.addProduct(product10, 999);

        // הוספת 10 הזמנות שונות (בדחיפויות שונות עם קומבינציות שונות של מוצרים)
        List<Product> order1Products = Arrays.asList(product1, product2, product3);
        ordersManagement.addOrder(order1Products, "Haifa", 5);

        List<Product> order2Products = Arrays.asList(product3, product4, product6);
        ordersManagement.addOrder(order2Products, "Tokyo", 2);

        List<Product> order3Products = Arrays.asList(product5, product7);
        ordersManagement.addOrder(order3Products, "Jerusalem", 1);

        List<Product> order4Products = Arrays.asList(product6, product8, product9);
        ordersManagement.addOrder(order4Products, "Eilat", 4);

        List<Product> order5Products = Arrays.asList(product10, product2);
        ordersManagement.addOrder(order5Products, "Washington", 3);

        List<Product> order6Products = Arrays.asList(product1, product7);
        ordersManagement.addOrder(order6Products, "Mumbai", 6);

        List<Product> order7Products = Arrays.asList(product2, product8);
        ordersManagement.addOrder(order7Products, "Beijing", 7);

        List<Product> order8Products = Arrays.asList(product9, product10);
        ordersManagement.addOrder(order8Products, "Rome", 8);

        List<Product> order9Products = Arrays.asList(product4, product5);
        ordersManagement.addOrder(order9Products, "Paris", 9);

        List<Product> order10Products = Arrays.asList(product1, product3, product6);
        ordersManagement.addOrder(order10Products, "Tel Aviv", 10);

        // הוספת 5 מוצרים נוספים למחסן
        Product product11 = new Product(1010, "Grapes");
        Product product12 = new Product(1011, "Melon");
        Product product13 = new Product(1012, "Mango");
        Product product14 = new Product(1013, "Peach");
        Product product15 = new Product(1014, "Water melon");

        inventory.addProduct(product11, 300);
        inventory.addProduct(product12, 400);
        inventory.addProduct(product13, 500);
        inventory.addProduct(product14, 600);
        inventory.addProduct(product15, 700);

        // שליחת 3 ההזמנות הדחופות ביותר
        ordersManagement.shipNOrders(3);

        // הדפסת שלושת הדוחות:
        // 1. דוח הזמנות כלליות
        ordersManagement.generateOrderReport();

        // 2. דוח הזמנות הכי דחופות ביותר
        ordersManagement.generateTopKOrdersReport(3);

        // 3. דוח מלאי מסודר
        ordersManagement.generateInventoryReport();
    }
}

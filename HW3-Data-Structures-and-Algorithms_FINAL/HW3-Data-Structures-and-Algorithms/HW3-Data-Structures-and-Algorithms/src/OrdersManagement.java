import java.util.*;

public class OrdersManagement {
    private PriorityQueue<Order> orders;
    private StorageInventory inventory;

    public OrdersManagement(StorageInventory inventory) {
        this.orders = new PriorityQueue<>();
        this.inventory = inventory;
    }

    public void addOrder(List<Product> products, String destination, int priority) {
        if (products == null || products.isEmpty() || destination == null || priority <= 0) {
            System.out.println("Invalid order details.");
            return;
        }
        if (!checkInventoryForOrder(products)) {
            System.out.println("Can't place an order. Some products are not in stock.");
            return;
        }
        Order order = new Order(products, destination, priority);
        orders.add(order);
        for (Product product : order.getProducts()) {
            inventory.reduceInventory(product, 1);
        }
        System.out.println("Order added successfully.");
    }

    public boolean checkInventoryForOrder(List<Product> products) {
        for (Product product : products) {
            if (inventory.checkInventory(product) <= 0) {
                return false;
            }
        }
        return true;
    }

    public void shipNOrders(int n) {
        int temp = n;
        while (n != 0) {
            orders.poll();
            n--;
            if (orders.size() == 0)
                break;
        }
        temp = temp - n;
        System.out.printf("Sent %d orders%n", temp);
    }

    public void generateOrderReport() {
        int totalOrders = orders.size();
        int cantBeOrdered = 0;
        int highPriorityOrders = 0;
        int maxPriority = !orders.isEmpty() ? orders.peek().getPriority() : 0;

        for (Order order : orders) {
            if (!checkInventoryForOrder(order.getProducts())) {
                cantBeOrdered++;
            }
            if (order.getPriority() == maxPriority) {
                highPriorityOrders++;
            }
        }
        System.out.println("Total Orders report: " + totalOrders);
        System.out.println("Unsatisfiable Orders report: " + cantBeOrdered);
        System.out.println("High Priority Orders report: " + highPriorityOrders);
    }

    public void generateInventoryReport() {
        List<Map.Entry<Product, Integer>> inventoryList = new ArrayList<>(inventory.getInventory().entrySet());
        inventoryList.sort(Map.Entry.comparingByValue());

        System.out.println("Inventory Report (sorted by quantity):");
        for (Map.Entry<Product, Integer> entry : inventoryList) {
            System.out.println("Product: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }

    public void generateTopKOrdersReport(int k) {
        List<Order> orderList = new ArrayList<>(orders);
        orderList.sort((o1, o2) -> Integer.compare(o2.getProducts().size(), o1.getProducts().size()));

        System.out.println("Top " + k + " Orders with the most products:");
        for (int i = 0; i < Math.min(k, orderList.size()); i++) {
            System.out.println(orderList.get(i));
        }
    }
}

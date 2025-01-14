import java.util.HashMap;

public class StorageInventory
{
	 // בחרנו במבנה הנתונים HashMap
    private HashMap<Product, Integer> inventory; // מפתח: Product, ערך: כמות במלאי

    public StorageInventory() 
    {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) 
    { //הוספת מוצר חדש-הכנסה למלאי
    	if(product == null || quantity <= 0 || inventory.containsKey(product))
    	{
            System.out.println("Product is already in inventory, or it's illegal, or quantity isn't valid");
            return;
        }
        // אם המוצר כבר קיים, נוסיף לכמות הקיימת
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
        System.out.println("The product was added to the inventory succesfully (:");
    }
    
    
    public int checkInventory(Product product) 
    { //בדיקת מלאי עבור מוצר
    	if (!inventory.containsKey(product)) {
            System.out.println("The product doesn't exist in our inventory");
            return 0;
        }
        return inventory.get(product);
    }
    
    
    public void removeProduct(Product product) 
    { //מחיקת מוצר לגמרי מהמחסן והורדה מכמות המלאי של מוצר
    	if (!inventory.containsKey(product)) {
            System.out.println("Product doesn't exist in inventory.");
            return;
        }
        inventory.remove(product);
        System.out.println("The requested product was succesfully removed from our inventory");
    }
    
   
    public void reduceInventory(Product product, int quantity) 
    { // הורדת כמות מהמלאי של מוצר
        if(!inventory.containsKey(product))
        {
            System.out.println("The product doesn't exist in our inventory");
            return;
        }
        if(quantity <= 0 || inventory.get(product) < quantity) 
        {
            System.out.println("Quantity is incorrect or the product is out of stock.");
            return;
        }
        inventory.put(product, inventory.get(product) - quantity);
        System.out.println("Reducing the quantity from the stock of a product was successfully done!");
    }
    public void printInventory() {
        // הדפסת כל המלאי
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            inventory.forEach((product, quantity) -> {
                System.out.println("Product: " + product + ", Quantity: " + quantity);
            });
        }
    }
}
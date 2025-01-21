import java.util.ArrayList;
import java.util.List;

public class Order implements Comparable<Order> {
	private List<Product> products;
    private String destination;
    private int priority;

    public Order(List<Product> products, String destination, int priority) {
        this.products = new ArrayList<>(products);
        this.destination = destination;
        this.priority = priority;
    }

    public List<Product> getProducts() {
		return products;
	}

	public String getDestination() {
		return destination;
	}

	public int getPriority() {
		return priority;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Override
    public int compareTo(Order o) {
        return Integer.compare(o.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Order{products=" + products + ", destination='" + destination + '\'' + ", priority=" + priority + '}';
    }
}

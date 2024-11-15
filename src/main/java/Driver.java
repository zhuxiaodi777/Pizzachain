import java.util.ArrayList;
import java.util.List;

/**
 * Represents a delivery driver in the system.
 */
class Driver extends Employee {
	private List<Order> assignedOrders;
	private String currentLocation;

	// Constructor
	public Driver(int id, String name, double salary, String schedule) {
		super(id, name, salary, schedule);
		this.assignedOrders = new ArrayList<>();
		this.currentLocation = "Warehouse";
	}

	// Assign a new order to the driver
	public void assignOrder(Order order) {
		assignedOrders.add(order);
		order.updateStatus("Assigned to Driver");
		System.out.println("Order ID " + order.getId() + " assigned to driver " + getName());
	}

	// Deliver the assigned order
	public void deliverOrder(Order order) {
		if (assignedOrders.contains(order)) {
			order.updateStatus("Delivered");
			assignedOrders.remove(order);
			System.out.println("Order ID " + order.getId() + " has been delivered.");
		} else {
			System.out.println("Order not assigned to this driver.");
		}
	}

	// Track the current location of the driver
	public void trackLocation(String location) {
		this.currentLocation = location;
		System.out.println("Driver " + getName() + " is currently at " + location);
	}

	// Generate a report of completed deliveries
	public void generateDeliveryReport() {
		System.out.println("Delivery Report for Driver " + getName() + ":");
		for (Order order : assignedOrders) {
			System.out.println("Order ID: " + order.getId() + " - Status: " + order.getStatus());
		}
	}

	// Update driver schedule
	public void updateSchedule(String newSchedule) {
		setSchedule(newSchedule);
		System.out.println("Schedule updated for driver " + getName());
	}

	// Getters
	public String getCurrentLocation() {
		return currentLocation;
	}

	public List<Order> getAssignedOrders() {
		return assignedOrders;
	}
}

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a customer in the system, including their orders and feedback.
 */
class Customer {
	private String name;
	private String contactInfo;
	private String address;
	private List<Order> orderHistory;
	private List<Feedback> feedbackHistory;

	// Constructor
	public Customer(String name, String contactInfo, String address) {
		this.name = name;
		this.contactInfo = contactInfo;
		this.address = address;
		this.orderHistory = new ArrayList<>();
		this.feedbackHistory = new ArrayList<>();
	}

	// Place a new order
	public void placeOrder(Order order) {
		if (order == null) {
			throw new IllegalArgumentException("Order cannot be null");
		}
		orderHistory.add(order);
		System.out.println("Order placed successfully: " + order.getId());
	}

	// Provide feedback on a specific order
	public void provideFeedback(Order order, Feedback feedback) {
		if (!orderHistory.contains(order)) {
			System.out.println("Order not found in history.");
			return;
		}
		feedbackHistory.add(feedback);
		System.out.println("Feedback provided for order ID " + order.getId());
	}

	// Update customer information
	public void updateContactInfo(String newContactInfo) {
		this.contactInfo = newContactInfo;
		System.out.println("Contact information updated.");
	}

	public void updateAddress(String newAddress) {
		this.address = newAddress;
		System.out.println("Address updated.");
	}

	// View all orders placed by the customer
	public void viewOrderHistory() {
		if (orderHistory.isEmpty()) {
			System.out.println("No orders found.");
		} else {
			System.out.println("Order History:");
			for (Order order : orderHistory) {
				System.out.println("Order ID: " + order.getId() + ", Status: " + order.getStatus());
			}
		}
	}

	// View feedback history
	public void viewFeedbackHistory() {
		if (feedbackHistory.isEmpty()) {
			System.out.println("No feedback found.");
		} else {
			System.out.println("Feedback History:");
			for (Feedback feedback : feedbackHistory) {
				System.out.println("Date: " + feedback.getDate() + ", Rating: " + feedback.getRating());
				System.out.println("Comments: " + feedback.getComments());
			}
		}
	}

	// Cancel an order by ID
	public void cancelOrder(int orderId) {
		Order orderToCancel = null;
		for (Order order : orderHistory) {
			if (order.getId() == orderId) {
				orderToCancel = order;
				break;
			}
		}
		if (orderToCancel != null) {
			orderToCancel.updateStatus("Cancelled");
			System.out.println("Order ID " + orderId + " has been cancelled.");
		} else {
			System.out.println("Order ID " + orderId + " not found in history.");
		}
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public String getAddress() {
		return address;
	}

	public List<Order> getOrderHistory() {
		return orderHistory;
	}

	public List<Feedback> getFeedbackHistory() {
		return feedbackHistory;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Count total number of orders
	public int getTotalOrders() {
		return orderHistory.size();
	}

	// Calculate average feedback rating
	public double getAverageRating() {
		if (feedbackHistory.isEmpty()) {
			return 0.0;
		}
		int totalRating = 0;
		for (Feedback feedback : feedbackHistory) {
			totalRating += feedback.getRating();
		}
		return (double) totalRating / feedbackHistory.size();
	}

	// Retrieve latest order
	public Order getLatestOrder() {
		if (orderHistory.isEmpty()) {
			return null;
		}
		return orderHistory.get(orderHistory.size() - 1);
	}

	// Check if a specific order exists in history
	public boolean hasOrder(int orderId) {
		for (Order order : orderHistory) {
			if (order.getId() == orderId) {
				return true;
			}
		}
		return false;
	}

	// Print customer details
	public void printCustomerDetails() {
		System.out.println("Customer Details:");
		System.out.println("Name: " + name);
		System.out.println("Contact Info: " + contactInfo);
		System.out.println("Address: " + address);
		System.out.println("Total Orders: " + getTotalOrders());
		System.out.println("Average Rating: " + getAverageRating());
	}
}

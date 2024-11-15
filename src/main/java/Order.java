public class Order {
	private Integer id;
	private String type;  // e.g., "Takeout" or "Delivery"
	private String status;  // e.g., "Pending", "Completed"
	private OrderDetail orderDetails;

	// Constructor to initialize Order with ID, type, and default status
	public Order(Integer id, String type) {
		this.id = id;
		this.type = type;
		this.status = "Pending";  // Default status
		this.orderDetails = new OrderDetail();  // Initialize empty OrderDetail
	}

	// Getter for OrderDetail
	public OrderDetail getOrderDetails() {
		return orderDetails;
	}

	// Method to update the status of the order
	public void updateStatus(String status) {
		this.status = status;
	}

	// Getter for status
	public String getStatus() {
		return status;
	}

	public double calculateTotalPrice() {
		return orderDetails.calculateTotalPrice();
	}

	// Overridden toString method to display order details
	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", type='" + type + '\'' +
				", status='" + status + '\'' +
				", orderDetails=" + orderDetails +
				'}';
	}

	public int getId() {
		return 0;
	}
}

import java.util.ArrayList;
import java.util.List;

public class OrderDetail {
	private List<Item> items;
	private List<Integer> quantities;
	private String specialInstructions;
	private String deliveryLocation;

	public OrderDetail() {
		this("Default Location", "No special instructions");
	}

	// Constructor to initialize empty lists for items and quantities
	public OrderDetail(String deliveryLocation, String specialInstructions) {
		this.items = new ArrayList<>();
		this.quantities = new ArrayList<>();
		this.specialInstructions = specialInstructions;
		this.deliveryLocation = deliveryLocation;
	}

	public List<Item> getItems() {
		return items;
	}
	// Method to add an item with a specific quantity to the order
	public void addItem(Item item, Integer quantity) {
		items.add(item);
		quantities.add(quantity);
	}

	// Method to calculate the total price of the order
	public Double calculateTotalPrice() {
		double total = 0;
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getPrice() * quantities.get(i);
		}
		return total;
	}

	// Getter for delivery location
	public String getDeliveryLocation() {
		return deliveryLocation;
	}

	// Getter for special instructions
	public String getSpecialInstructions() {
		return specialInstructions;
	}

	// Overridden toString method to display order details
	@Override
	public String toString() {
		StringBuilder details = new StringBuilder("OrderDetail{");
		for (int i = 0; i < items.size(); i++) {
			details.append(items.get(i).getName())
					.append(" x")
					.append(quantities.get(i))
					.append(", ");
		}
		details.append("Total Price=").append(calculateTotalPrice())
				.append(", Delivery Location='").append(deliveryLocation)
				.append("', Special Instructions='").append(specialInstructions)
				.append("'}");
		return details.toString();
	}
}

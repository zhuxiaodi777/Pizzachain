public class Item {
	private String name;
	private String description;
	private double price;
	private boolean availability;

	// Constructor to initialize item details
	public Item(String name, String description, double price, boolean availability) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.availability = availability;
	}

	// Method to set availability
	public void setAvailability(boolean available) {
		this.availability = available;
	}

	// Getter for availability
	public boolean isAvailable() {
		return availability;
	}

	// Getter for price
	public double getPrice() {
		return price;
	}

	// Getter for name
	public String getName() {
		return name;
	}

	// Getter for description
	public String getDescription() {
		return description;
	}

	// Overridden toString method to display item details
	@Override
	public String toString() {
		return "Item{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", price=" + price +
				", availability=" + availability +
				'}';
	}
}

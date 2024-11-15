import java.util.ArrayList;
import java.util.List;

public class Chain {
    private String name;
    private List<Store> stores;

    // Constructor to initialize Chain with a name and empty store list
    public Chain(String name) {
        this.name = name;
        this.stores = new ArrayList<>();
    }

    // Getter for the name
    public String getName() {
        return name;
    }

    // Setter for the name
    public void setName(String name) {
        this.name = name;
    }

    // Add a store to the chain
    public void addStore(Store store) {
        stores.add(store);
    }

    // Remove a store from the chain
    public void removeStore(Store store) {
        stores.remove(store);
    }

    // Get all stores in the chain
    public List<Store> getStores() {
        return stores;
    }

    // Method to analyze feedback from all stores in the chain
    public void analyzeFeedback() {
        System.out.println("Analyzing feedback for the chain: " + name);
        for (Store store : stores) {
            // Assume each store has some feedback-related functionality
            System.out.println("Feedback for store at " + store.getLocation() + ": ");
            // Placeholder for feedback analysis logic
        }
    }

    // ToString method for displaying chain details
    @Override
    public String toString() {
        return "Chain{name='" + name + "', stores=" + stores.size() + "}";
    }
}

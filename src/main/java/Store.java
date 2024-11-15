import java.util.ArrayList;
import java.util.List;

public class Store {
    private String location;
    private String workingHours;
    private String rulesForDelivery;
    private double totalRevenue;
    private Menu menu;
    private List<Order> orders;
    private Accounting accounting;
    private List<Employee> employees;

    // Constructor to initialize a Store with basic information and empty lists for orders and employees
    public Store(String location, String workingHours, String rulesForDelivery) {
        this.location = location;
        this.workingHours = workingHours;
        this.rulesForDelivery = rulesForDelivery;
        this.totalRevenue = 0;
        this.menu = new Menu();
        this.orders = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.accounting = new Accounting();
    }

    // Getter for location
    public String getLocation() {
        return location;
    }

    // Getter for working hours
    public String getWorkingHours() {
        return workingHours;
    }

    // Getter for rules for delivery
    public String getRulesForDelivery() {
        return rulesForDelivery;
    }

    // Get the menu
    public Menu getMenu() {
        return menu;
    }

    // Get list of orders
    public List<Order> getOrders() {
        return orders;
    }

    // Manage accounting
    public Accounting manageAccounting() {
        return accounting;
    }

    // Add an employee to the store
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Place an order
    public void placeOrder(Order order) {
        orders.add(order);
        totalRevenue += order.calculateTotalPrice();
    }

    // Get total revenue
    public double getTotalRevenue() {
        return totalRevenue;
    }

    // Display store information
    @Override
    public String toString() {
        return "Store{" +
                "location='" + location + '\'' +
                ", workingHours='" + workingHours + '\'' +
                ", rulesForDelivery='" + rulesForDelivery + '\'' +
                ", totalRevenue=" + totalRevenue +
                ", employees=" + employees.size() +
                '}';
    }
}

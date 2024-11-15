public class Main {
    public static void main(String[] args) {
        // Create some items for the menu
        Item pizza = new Item("Pizza", "Delicious cheese pizza", 10.99, true);
        Item burger = new Item("Burger", "Juicy beef burger", 8.99, true);

        // Create a menu and add items
        Menu menu = new Menu();
        menu.addItem(pizza);
        menu.addItem(burger);

        // Create a store and assign the menu to it
        Store store = new Store("Downtown", "9 AM - 10 PM", "No delivery beyond 10 miles", menu);

        // Create a customer
        Customer customer = new Customer("John Doe", "123-456-7890", "123 Main St");

        // Customer places an order
        Order order = new Order(1, "Takeout");
        order.addItem(pizza, 2);  // Order 2 pizzas
        customer.placeOrder(order);

        // Print order details
        System.out.println("Customer: " + customer.getName());
        System.out.println("Order Total: $" + order.calculateTotalPrice());
        System.out.println("Order Status: " + order.getStatus());
    }
}

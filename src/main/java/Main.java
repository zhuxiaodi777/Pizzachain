public class Main {
    public static void main(String[] args) {
        Chain pizzaChain = new Chain("Pizza Delight");

        Store store1 = new Store("Downtown", "9 AM - 10 PM", "10-mile radius");
        Store store2 = new Store("Uptown", "10 AM - 11 PM", "15-mile radius");

        pizzaChain.addStore(store1);
        pizzaChain.addStore(store2);

        System.out.println(pizzaChain);

        pizzaChain.analyzeFeedback();
    }

}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDetailTest {

    @Test
    public void testAddItem() {
        // Arrange: 创建 Item 对象，并添加到 OrderDetail 中
        Item pizza = new Item("Pizza", "Cheesy and delicious", 10.99, true);
        Item burger = new Item("Burger", "Juicy beef burger", 5.99, true);
        OrderDetail orderDetail = new OrderDetail("123 Main St", "Extra napkins");

        // Act: 添加 Item 对象到 OrderDetail 中
        orderDetail.addItem(pizza, 2);  // 添加 2 份披萨
        orderDetail.addItem(burger, 1); // 添加 1 份汉堡

        // Assert: 验证订单中的商品数量
        assertEquals(2, orderDetail.getItems().size(), "There should be 2 items in the order");
    }

    @Test
    public void testCalculateTotalPrice() {
        // Arrange: 创建 Item 对象
        Item pizza = new Item("Pizza", "Cheesy and delicious", 10.99, true);
        Item burger = new Item("Burger", "Juicy beef burger", 5.99, true);
        OrderDetail orderDetail = new OrderDetail("123 Main St", "Extra napkins");

        // Act: 添加 Item 对象到 OrderDetail 中
        orderDetail.addItem(pizza, 2);  // 添加 2 份披萨
        orderDetail.addItem(burger, 1); // 添加 1 份汉堡

        // Act: 计算总价
        double totalPrice = orderDetail.calculateTotalPrice();

        // Assert: 验证总价是否正确
        double expectedTotal = (2 * 10.99) + (1 * 5.99); // 预计总价
        assertEquals(expectedTotal, totalPrice, 0.01, "The total price should match the expected value");
    }

    @Test
    public void testToString() {
        // Arrange: 创建 Item 对象
        Item pizza = new Item("Pizza", "Cheesy and delicious", 10.99, true);
        Item burger = new Item("Burger", "Juicy beef burger", 5.99, true);
        OrderDetail orderDetail = new OrderDetail("123 Main St", "Extra napkins");

        // Act: 添加 Item 对象到 OrderDetail 中
        orderDetail.addItem(pizza, 2);  // 添加 2 份披萨
        orderDetail.addItem(burger, 1); // 添加 1 份汉堡

        // Act: 获取订单的字符串表示
        String orderDetailString = orderDetail.toString();

        // Assert: 验证 toString 方法的输出
        String expectedString = "OrderDetail{Pizza x2, Burger x1, Total Price=27.97, Delivery Location='123 Main St', Special Instructions='Extra napkins'}";
        assertEquals(expectedString, orderDetailString, "The toString method should return the correct order details");
    }
}

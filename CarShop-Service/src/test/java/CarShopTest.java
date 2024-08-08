import carshop.model.*;
import carshop.services.CarService;
import carshop.services.OrderService;
import carshop.services.UserService;
import org.junit.jupiter.api.Test;


import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

public class CarShopTest {
    UserService userService = new UserService();
    CarService carService = new CarService();
    OrderService orderService = new OrderService();
    private List<Order> orders = orderService.getAllOrders();


    @Test
    public void testAuthenticate_ValidCredentials_ReturnsUser() {
        userService.registration("Kate", "1111", Role.CLIENT, "OverRandom");
        User result = userService.authenticate("Kate", "1111");
        assertNotNull(result);
        assertEquals("Kate", result.getUsername());
    }

    @Test
    public void testAuthenticate_InvalidUsername_ReturnsNull() {
        User result = userService.authenticate("invalidUser", "password123");
        assertNull(result);
    }

    @Test
    public void testAuthenticate_InvalidPassword_ReturnsNull() {
        User result = userService.authenticate("testUser", "wrongPassword");
        assertNull(result);
    }

    @Test
    public void testCreateOrderPurchase_Success() {
        User user = new User("testUser", "password123", Role.CLIENT, "Some info");
        Car car = new Car("Toyota", "Camry", 1999, 100000, CarCondition.EXCELLENT); // Создаем автомобиль, который не продан

        orderService.createOrderPurchase(user, car);
        assertEquals(1, orders.size());
        Order createdOrder = orders.get(0);
        assertEquals(user, createdOrder.getCustomer());
        assertEquals(car, createdOrder.getCar());
        assertEquals("Pending", createdOrder.getStatus());

        assertTrue(car.isSold());

        assertEquals(1, user.getPurchases());
    }

    @Test
    public void testCreateOrderPurchase_CarAlreadySold() {
        User user = new User("testUser", "password123", Role.CLIENT, "Some info");
        Car car = new Car("Toyota", "Camry", 1999, 100000, CarCondition.EXCELLENT);
        car.sell();
        orderService.createOrderPurchase(user, car);
        assertEquals(0, orders.size());
    }
}

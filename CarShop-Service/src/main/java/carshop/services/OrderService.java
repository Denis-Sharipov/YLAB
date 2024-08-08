package carshop.services;

import carshop.model.Car;
import carshop.model.Order;
import carshop.model.OrderType;
import carshop.model.User;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class OrderService {
    private final List<Order> orders;
    private static Logger logger;

    static {
        try(FileInputStream ins = new FileInputStream("C:\\Users\\Admin\\Documents\\Quality Expert\\CarShop-Service\\src\\main\\resources\\log.txt")){
            LogManager.getLogManager().readConfiguration(ins);
            logger = Logger.getLogger(OrderService.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    public OrderService() {
        this.orders = new ArrayList<>();
    }

    public void createOrderPurchase(User user, Car car) {
        if (!car.isSold()) {
            Order order = new Order(user, car, "Pending", new Date(), OrderType.PURCHASE);
            orders.add(order);
            car.sell();
            user.addPurchase();
            logger.log(Level.INFO, "Создан новый заказ.\n" + order);
        } else {
            System.out.println("Автомобиль уже продан. :(");
        }
    }

    public void createOrderService(User customer, Car car) {
        if (car.isSold()) {
            Order order = new Order(customer, car, "Pending", new Date(), OrderType.SERVICE);
            orders.add(order);
            logger.log(Level.INFO, "Создан новый заказ.\n" + order);
        } else {
            System.out.println("Автомобиль ещё не куплен. :(");
        }
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }

    public List<Order> getOrdersByUser(User user){
        List<Order> ordersByUser = new ArrayList<>();
        for (Order order : orders){
            if (order.getCustomer().equals(user)){
                ordersByUser.add(order);
            }
        }
        return ordersByUser;
    }

    public List<Order> getOrdersByCar(Car car){
        List<Order> ordersByCar = new ArrayList<>();
        for (Order order : orders){
            if (order.getCar().equals(car)){
                ordersByCar.add(order);
            }
        }
        return ordersByCar;
    }

    public List<Order> getOrdersByDate(Date date){
        List<Order> ordersByDate = new ArrayList<>();
        for (Order order : orders){
            if (order.getDate().equals(date)){
                ordersByDate.add(order);
            }
        }
        return ordersByDate;
    }

    public List<Order> getOrdersByStatus(String status){
        List<Order> ordersByStatus = new ArrayList<>();
        for (Order order : orders){
            if (order.getStatus().equals(status)){
                ordersByStatus.add(order);
            }
        }
        return ordersByStatus;
    }

    public List<Order> getOrdersByOrderType(OrderType type){
        List<Order> ordersByType = new ArrayList<>();
        for (Order order : orders){
            if (order.getOrderType().equals(type)){
                ordersByType.add(order);
            }
        }
        return ordersByType;
    }

    public void setOrderStatus(Order order, String status){
        order.setStatus(status);
    }

    public void setOrderCustomer(Order order, User customer){
        order.setCustomer(customer);
    }

    public void setOrderDate(Order order, Date date){
        order.setDate(date);
    }

    public void setOrderCar(Order order, Car car){
        order.setCar(car);
    }

    public void setOrderType(Order order, OrderType orderType){
        order.setOrderType(orderType);
    }

}

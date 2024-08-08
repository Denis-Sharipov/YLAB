package carshop.model;

import java.util.Date;

public class Order {
    private User customer;
    private Car car;
    private String status;
    private Date date;
    private OrderType orderType;

    public Order(User customer, Car car, String status, Date date, OrderType orderType) {
        this.customer = customer;
        this.car = car;
        this.status = status;
        this.date = date;
        this.orderType = orderType;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String toString(){
        return "Заказчик: " + getCustomer().getUsername() + ",\nавтомобиль: " + getCar().toString() + ",\nстатус:" + getStatus() + ",\nтип заказа: " + getOrderType() + ",\nвремя: " + getDate();
    }
}

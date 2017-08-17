package ru.bk.rom4ik2103.services;


import ru.bk.rom4ik2103.ordersPuck.Order;


import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    void deleteOrder(long [] ids);
    Order findOrderById(Long ids);
    List<Order> showListOfOrders();
    void updateOrder(Order order);
    List<Order> showListOfOrdersByStatus(String status);
}

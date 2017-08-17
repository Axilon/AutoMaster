package ru.bk.rom4ik2103.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bk.rom4ik2103.dao.OrderDAO;
import ru.bk.rom4ik2103.ordersPuck.Order;
import ru.bk.rom4ik2103.productPuck.Product;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public void addOrder(Order order) {
        orderDAO.save(order);
    }

    @Override
    @Transactional
    public Order findOrderById(Long ids) {
        return orderDAO.findOne(ids);
    }

    @Override
    @Transactional
    public void deleteOrder(long[] idList) {

        for (long id : idList)

            orderDAO.delete(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<Order> showListOfOrders() {
        return orderDAO.findAll();
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        orderDAO.save(order);
    }

    @Override
    @Transactional
    public List<Order> showListOfOrdersByStatus(String status) {
        return orderDAO.showListOfOrdersByStatus(status);
    }
}

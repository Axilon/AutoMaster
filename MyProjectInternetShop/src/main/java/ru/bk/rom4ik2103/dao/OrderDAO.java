package ru.bk.rom4ik2103.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import ru.bk.rom4ik2103.ordersPuck.Order;

import java.util.List;


public interface OrderDAO extends JpaRepository<Order,Long>{

    @Query ("SELECT o FROM Order o WHERE o.orderStatus = :orderStatus")
    List<Order>showListOfOrdersByStatus(@Param("orderStatus") String orderStatus);

}

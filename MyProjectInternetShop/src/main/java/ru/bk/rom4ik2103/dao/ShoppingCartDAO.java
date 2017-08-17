package ru.bk.rom4ik2103.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.bk.rom4ik2103.shoppingCartPuck.ShoppingCart;

import java.util.List;

/**
 * Created by user on 12.08.2017.
 */
public interface ShoppingCartDAO extends JpaRepository<ShoppingCart,Long> {

    @Query("SELECT sc FROM ShoppingCart sc WHERE sc.userLogin = :userLogin")
    List<ShoppingCart> showListOfProductsByUserLoginFromShoppingCart(@Param("userLogin") String userLogin);

    @Query("DELETE  FROM ShoppingCart sc WHERE sc.userLogin = :userLogin")
    void deleteProductsByUserLoginFromShoppingCart(@Param("userLogin") String userLogin);


}

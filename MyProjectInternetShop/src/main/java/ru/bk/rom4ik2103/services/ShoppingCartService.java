package ru.bk.rom4ik2103.services;

import org.springframework.data.repository.query.Param;
import ru.bk.rom4ik2103.shoppingCartPuck.ShoppingCart;

import java.util.List;

/**
 * Created by user on 12.08.2017.
 */
public interface ShoppingCartService {
    void addProductToShoppingCart(ShoppingCart shoppingCart);
    void deleteProductFromShoppingCartById(long id);
    List<ShoppingCart> showListOfProductsByUserLoginFromShoppingCart(String login);
    void deleteProductsByUserLoginFromShoppingCart(String userLogin);

}

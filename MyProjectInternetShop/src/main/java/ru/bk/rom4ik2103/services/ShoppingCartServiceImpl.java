package ru.bk.rom4ik2103.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bk.rom4ik2103.dao.ShoppingCartDAO;
import ru.bk.rom4ik2103.shoppingCartPuck.ShoppingCart;

import java.util.List;

/**
 * Created by user on 12.08.2017.
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartDAO shoppingCartDAO;

    @Override
    @Transactional
    public void addProductToShoppingCart(ShoppingCart shoppingCart) {
        shoppingCartDAO.save(shoppingCart);
    }

    @Override
    @Transactional
    public void deleteProductFromShoppingCartById(long id) {
        shoppingCartDAO.delete(id);
    }

    @Override
    @Transactional (readOnly = true)
    public List<ShoppingCart> showListOfProductsByUserLoginFromShoppingCart(String login) {
        return shoppingCartDAO.showListOfProductsByUserLoginFromShoppingCart(login);
    }

    @Override
    @Transactional
    public void deleteProductsByUserLoginFromShoppingCart(String userLogin) {
        shoppingCartDAO.deleteProductsByUserLoginFromShoppingCart(userLogin);
    }
}

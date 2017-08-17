package ru.bk.rom4ik2103.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import ru.bk.rom4ik2103.dao.ProductDAO;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;

import java.util.List;

/**
 * Created by user on 25.05.2017.
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public void addProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    @Transactional
    public void deleteProductById(long[] ids) {
        for(long id : ids){
            productDAO.delete(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductById(long ids) {
        return productDAO.findOne(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public Product findProductByName(String name) {
        return productDAO.findProductByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> showListOfProducts() {
        return productDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> showListOfProductsByProductType(ProductType productType) {
        return productDAO.showListOfProductsByProductType(productType);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDAO.save(product);
    }




    @Override
    @Transactional(readOnly = true)
    public List<Product> showListBySearchLine(String pattern, Pageable pageable) {
        return productDAO.showListBySearchLine(pattern, pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> showListOfProducts(Pageable pageable) {
        return productDAO.findAll(pageable).getContent();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> showListOfProductsByProductType(ProductType productType, Pageable pageable) {
        return productDAO.showListOfProductsByProductType(productType, pageable);
    }


    @Override
    @Transactional(readOnly = true)
    public long countByProductType(ProductType productType) {

        return productDAO.countByProductType(productType);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return productDAO.count();
    }
}

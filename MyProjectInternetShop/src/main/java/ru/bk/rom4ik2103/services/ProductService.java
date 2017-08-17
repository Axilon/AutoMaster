package ru.bk.rom4ik2103.services;

import org.springframework.data.repository.query.Param;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * Created by user on 25.05.2017.
 */
public interface ProductService {
    void addProduct(Product product);
    void deleteProductById (long[] ids);
    Product findProductById(long ids);
    Product findProductByName( String name);
    List<Product> showListOfProducts ();
    List<Product> showListOfProducts (Pageable pageable);
    List<Product> showListOfProductsByProductType (ProductType productType);
    List<Product> showListOfProductsByProductType (ProductType productType, Pageable pageable);
    List<Product> showListBySearchLine (String pattern, Pageable pageable); //список по строке поиска
    void updateProduct(Product product);

    long countByProductType( ProductType productType);
    long count();
}

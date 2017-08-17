package ru.bk.rom4ik2103.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;

import org.springframework.data.domain.Pageable;
import java.util.List;


public interface ProductDAO  extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product findProductByName(@Param("name") String name);

    @Query("select p from Product p where p.productType = :productType")
    List<Product> showListOfProductsByProductType(@Param("productType") ProductType productType);

    @Query("select p from Product p where p.productType = :productType")
    List<Product> showListOfProductsByProductType(@Param("productType") ProductType productType, Pageable pageable);

    @Query("SELECT COUNT(p) FROM Product p WHERE p.productType = :productType")
    long countByProductType(@Param("productType") ProductType productType);

    @Query("SELECT p from Product p WHERE LOWER (p.name) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Product> showListBySearchLine(@Param("pattern") String pattern, Pageable pageable);



}



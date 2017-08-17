package ru.bk.rom4ik2103.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.bk.rom4ik2103.productPuck.ProductType;

import java.util.List;

public interface ProductTypeDAO extends JpaRepository<ProductType, Long>{

    @Query("SELECT p FROM ProductType p WHERE p.name = :name")
    ProductType findByName (@Param("name")String name);

}

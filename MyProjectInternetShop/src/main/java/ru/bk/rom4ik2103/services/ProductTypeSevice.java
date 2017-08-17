package ru.bk.rom4ik2103.services;

import ru.bk.rom4ik2103.productPuck.ProductType;

import java.util.List;


public interface ProductTypeSevice {
    void addProductType(ProductType productType);
    void deleteProtuctType(long [] ids);
    ProductType findById(long id);
    List<ProductType> showListOfProductType();
    ProductType findByName(String name);
    void updateProductType(ProductType productType);
}

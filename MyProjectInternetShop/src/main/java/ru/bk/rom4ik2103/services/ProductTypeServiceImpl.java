package ru.bk.rom4ik2103.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bk.rom4ik2103.dao.ProductTypeDAO;
import ru.bk.rom4ik2103.productPuck.ProductType;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeSevice{

    @Autowired
    private ProductTypeDAO productTypeDAO;

    @Override
    @Transactional
    public void addProductType(ProductType productType) {
        productTypeDAO.save(productType);
    }

    @Override
    @Transactional
    public void deleteProtuctType(long [] idsList) {
        for (long id :idsList) {
            productTypeDAO.delete(id);
        }

    }

    @Override
    @Transactional (readOnly = true)
    public ProductType findById(long id) {
        return productTypeDAO.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductType> showListOfProductType() {
        return productTypeDAO.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public ProductType findByName(String name) {
        return productTypeDAO.findByName(name);
    }

    @Override
    @Transactional
    public void updateProductType(ProductType productType) {
         productTypeDAO.save(productType);
    }
}

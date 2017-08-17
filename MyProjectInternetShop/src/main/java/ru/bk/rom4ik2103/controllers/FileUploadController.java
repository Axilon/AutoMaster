package ru.bk.rom4ik2103.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.bk.rom4ik2103.Exceptions.PhotoErrorException;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;
import ru.bk.rom4ik2103.services.ProductService;
import ru.bk.rom4ik2103.services.ProductTypeSevice;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class FileUploadController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeSevice productTypeService;


        /* --------------------------------  PRODUCTS  ---------------------------------------------------*/

    @RequestMapping(value = "/admin/product/{id}/photo_update", method = RequestMethod.POST)
    public String updateProductPhoto(@PathVariable(value = "id")long id,
                                     @RequestParam(value = "picture")MultipartFile photo){
        Product product = productService.findProductById(id);
        if ((photo.isEmpty())) {
            return"redirect:/admin/product/{"+id+"}";
        }else{
            String pictureName = savingFile(photo);

             product.setPicture(pictureName);
            productService.updateProduct(product);
        }
        return"redirect:/admin";
    }




/* ------------------------------------  PRODUCT TYPE  -----------------------------------------------*/



    @RequestMapping(value = "/admin/product_type/photo/{productType_id}/update", method = RequestMethod.POST)
    public String updateProductTypePhoto(@PathVariable (value = "productType_id")long id,@RequestParam(value = "picture")MultipartFile photo){
        ProductType productType = productTypeService.findById(id);
        if(photo.isEmpty()){
            return"redirect:/admin/product_type/{"+id+"}";
        }
            productType.setPicture(savingFile(photo));
            productTypeService.updateProductType(productType);

        return"redirect:/admin/product_type";
    }



        /* --------------------------------  PICTURE LOADER  ---------------------------------------------------*/

       private @ResponseBody String savingFile( MultipartFile file){
            String fileName = file.getOriginalFilename();
            String rootPath = "D:\\MyProjectInternetShop\\src\\main\\webapp\\WEB-INF\\static\\loadedPictures";
           try (BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(rootPath,fileName )));) {
               byte[] bytes = file.getBytes();
               stream.write(bytes);

               return fileName;
           } catch (Exception e) {
               return e.getMessage();
           }




       }
}

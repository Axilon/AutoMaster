package ru.bk.rom4ik2103.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.bk.rom4ik2103.Exceptions.PhotoErrorException;
import ru.bk.rom4ik2103.Exceptions.PhotoNotFoundException;
import ru.bk.rom4ik2103.ordersPuck.Order;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;
import ru.bk.rom4ik2103.services.*;

import java.io.IOException;

@Controller

public class AdminController {


    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeSevice productTypeService;
    @Autowired
    private UserService userService;


        /* --------------------------------  PRODUCTS  ---------------------------------------------------*/

    @RequestMapping(value = "/admin")
    public String adminPage(Model model){
        model.addAttribute("productTypes", productTypeService.showListOfProductType());
        model.addAttribute("products", productService.showListOfProducts());

        return "admin";
    }




    @RequestMapping(value = "/admin/product/add")
    public String addProductPage(Model model){
        model.addAttribute("productTypes", productTypeService.showListOfProductType());
        return "product";}

    @RequestMapping(value = "/admin/product/addNew", method = RequestMethod.POST)
    public String addProduct(@RequestParam(value = "productType", required = false) long productTypeId, String name, String discription, double price){
        Product product = new Product();
        product.setName(name);
        product.setDiscription(discription);
        product.setPrice(price);
        ProductType productType = productTypeService.findById(productTypeId);
        product.setProductType(productType);
        productService.addProduct(product);
        return "redirect:/admin";}

    @RequestMapping(value = "/admin/product/{id}")
    public String updateProductPage(@PathVariable (value = "id") long id, Model model){

        Product product = productService.findProductById(id);

        model.addAttribute("product", product);
        model.addAttribute("product_id", id);
        model.addAttribute("productTypes", productTypeService.showListOfProductType());

        return "product_update";
    }

    @RequestMapping (value = "/admin/product/{product_id}/update" , method = RequestMethod.POST)
    public String updateProduct(@PathVariable (value = "product_id")long id,
                                @RequestParam(value = "productType", required = false) long productTypeId,
                                @RequestParam String name,
                                @RequestParam String discription,
                                @RequestParam double price){
        Product product = productService.findProductById(id);
        product.setName(name);
        product.setDiscription(discription);
        product.setPrice(price);
        ProductType productType = productTypeService.findById(productTypeId);
        product.setProductType(productType);
        productService.updateProduct(product);
        return"redirect:/admin";
    }


    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteProduct(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            productService.deleteProductById(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }








    /* ------------------------------------  USERS  -----------------------------------------------*/


    @RequestMapping(value = "/admin/users ")
    public String usersList(Model model){
        model.addAttribute("users", userService.listOfUsers());
        return "users";
    }


    @RequestMapping(value = "/admin/users/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            userService.deleteUsers(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }




    /* ---------------------------------------  ORDERS  --------------------------------------------*/


    @RequestMapping(value = "/admin/orders")
    public String ordersList(Model model){
        model.addAttribute("orders", orderService.showListOfOrders());
        model.addAttribute("orders_status", orderService.showListOfOrdersByStatus(null));

        return "orders";
    }

    @RequestMapping(value = "/admin/orders/{id}")
    public String orderViewPage(
            @PathVariable(value = "id") long orderId, Model model){
            Order order = orderService.findOrderById(orderId);

            model.addAttribute("order_id", orderId);
            model.addAttribute("name", order.getName());
            model.addAttribute("price", order.getPrice());
            model.addAttribute("customerName", order.getCustomerName());
            model.addAttribute("customerAddress", order.getCustomerAddress());
            model.addAttribute("customerPhone" , order.getCustomerPhone());
            model.addAttribute("orderStatus", order.getOrderStatus());

        return "orderInfo";
    }

    @RequestMapping(value = "/admin/orders/update/{id}" , method = RequestMethod.POST)
    public String orderUpdate(
            @PathVariable(value = "id") long orderId,
            @RequestParam String name,
            @RequestParam double price,
            @RequestParam String customerName,
            @RequestParam String customerAddress,
            @RequestParam String customerPhone,
            @RequestParam String orderStatus){

        Order order = orderService.findOrderById(orderId);

        order.setName(name);
        order.setPrice(price);
        order.setCustomerName(customerName);
        order.setCustomerAddress(customerAddress);
        order.setCustomerPhone(customerPhone);
        order.setOrderStatus(orderStatus);

        orderService.updateOrder(order);

        return "redirect:/admin/orders";
    }

    @RequestMapping(value = "/admin/orders/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOrder(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            orderService.deleteOrder(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }





/* ------------------------------------  PRODUCT TYPE  -----------------------------------------------*/


    @RequestMapping(value = "/admin/product_type")
    public String productTypePage(Model model) {
    model.addAttribute("productTypes", productTypeService.showListOfProductType());
    return "product_type";

}


    @RequestMapping(value = "/admin/product_type/{id}")
    public String byProductTypePage(@PathVariable(value = "id")long productType_id, Model model) {


        model.addAttribute("productTypes", productTypeService.showListOfProductType());
        model.addAttribute("products", productService.showListOfProductsByProductType(productTypeService.findById(productType_id)));
        return "admin";
    }


    @RequestMapping(value = "/admin/product_type/add")
    public String productTypeAddPage(Model model) {
        model.addAttribute("productTypes", productTypeService.showListOfProductType());
        return "product_type_add";
    }
    @RequestMapping(value = "/admin/product_type/addNew", method = RequestMethod.POST)
    public String productTypeAdd(String name) {
        ProductType pt = new ProductType();
        pt.setName(name);
        productTypeService.addProductType(pt);
        return "redirect:/admin/product_type";
    }



    @RequestMapping(value = "/admin/product_type/{productType_id}/update", method = RequestMethod.POST)
    public String productTypeUpdate(@PathVariable("productType_id") long id, String name) {
        ProductType pt = productTypeService.findById(id);
        pt.setName(name);
        productTypeService.updateProductType(pt);
        return "redirect:/admin/product_type";
    }

    @RequestMapping(value = "/admin/product_type/{id}/change")
    public String productTypeUpdatePage(@PathVariable("id") long id, Model model) {
        ProductType pt = productTypeService.findById(id);
        String productTypeName = pt.getName();
        model.addAttribute("productType_id", id);
        model.addAttribute("productTypeName", productTypeName);
        model.addAttribute("productTypePicture", pt.getPicture());
        return "product_type_update";
    }

    @RequestMapping(value = "/admin/product_type/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteProductType(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            productTypeService.deleteProtuctType(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }


































}

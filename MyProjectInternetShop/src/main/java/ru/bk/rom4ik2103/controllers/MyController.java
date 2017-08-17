package ru.bk.rom4ik2103.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bk.rom4ik2103.ordersPuck.Order;
import ru.bk.rom4ik2103.productPuck.Product;
import ru.bk.rom4ik2103.productPuck.ProductType;
import ru.bk.rom4ik2103.services.*;
import ru.bk.rom4ik2103.shoppingCartPuck.ShoppingCart;
import ru.bk.rom4ik2103.usersPuck.CustomUser;
import ru.bk.rom4ik2103.usersPuck.UserRole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeSevice productTypeService;
    @Autowired
    private UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    ShoppingCartService shoppingCartService;

//    private Map<String,List<Product>> shoppingCart = new HashMap<>();

    static final int ITEMS_PER_PAGE = 25;

    @RequestMapping("/faq")
    public String faq(){
        return "faq";
    }

    @RequestMapping("/contacts")
    public String contacts(){ return "contacts";
    }

    @RequestMapping("/userCabinet")
    public String userCabinet(Model model){
        String login = getUserLogin();

        CustomUser dbUser = userService.getUserByLogin(login);

        model.addAttribute("login", login);
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.getPhone());
        return "userCabinet";
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);
        dbUser.setLogin(login);
        dbUser.setEmail(email);
        dbUser.setPhone(phone);

        userService.updateUser(dbUser);

        return "redirect:/userCabinet";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam String passwordRepeat,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         Model model) {
        if(!(password.equals(passwordRepeat))){
            model.addAttribute("wrongPasswords", true);
            return "register";
        }
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "register";
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER, email, phone);
        userService.addUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    @RequestMapping("/unauthorized")
    public String unauthorized(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }




    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam String pattern, Model model) {

        model.addAttribute("productTypes", productTypeService.showListOfProductType());
        model.addAttribute("products", productService.showListBySearchLine(pattern, null));

        return "products_and_categories";
    }

    @RequestMapping("/products")
    public String productsPage(Model model
                            ,@RequestParam(required = false, defaultValue = "0") Integer page){
        if (page < 0) page = 0;
        List<Product> products = productService
                .showListOfProducts( new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC,"id"));

        model.addAttribute("products", products);
        model.addAttribute("productTypes", productTypeService.showListOfProductType());
        model.addAttribute("allPages", getPageCount());
        return "products_and_categories";
    }

    @RequestMapping("/products/{id}")
    public String productViewPage(Model model,
                                  @PathVariable(value = "id") long productId,
                                  @RequestParam(value="productAdded", required = false) boolean yes){
        if(yes){
            model.addAttribute("productAdded", true);
        }
        model.addAttribute("product", productService.findProductById(productId));
        return "product_view_page";
    }
// -----------------------------------------------------
    @RequestMapping(value = "/products/{id}/add", method = RequestMethod.POST)
    public String productAddToShoppingCart(@PathVariable(value = "id") long productId, Model model){
        String login = getUserLogin();

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserLogin(login);
        shoppingCart.setProductId(productId);
        shoppingCartService.addProductToShoppingCart(shoppingCart);

        model.addAttribute("productAdded", true);
        model.addAttribute("id", productId);

        return "redirect:/products/{id}";

    }
// ------------------------------------------------------

    @RequestMapping ("/shoppingCart")
    public String shoppingCartPage(Model model){
        List<ShoppingCart> shoppingCarts = shoppingCartService.showListOfProductsByUserLoginFromShoppingCart(getUserLogin());
        List<Product> products = new ArrayList<>();
        double totalPriceCount = 0;
        for (ShoppingCart shoppingCart: shoppingCarts) {
            Product product = productService.findProductById(shoppingCart.getProductId());
            products.add(product);
            totalPriceCount+=product.getPrice();
        }
        if(totalPriceCount==0){
            model.addAttribute("totalPriceCount", null);
        }else {
            model.addAttribute("totalPriceCount", totalPriceCount);
            model.addAttribute("products", products);
        }
        return "shoppingCart";
    }
// ------------------------------------------------------
    @RequestMapping(value = "/shoppingCart/order", method = RequestMethod.POST)
    public String ordersOfProductsFromShoppingCart(Model model,
                                                   @RequestParam String customerName,
                                                   @RequestParam String customerAddress,
                                                   @RequestParam String customerPhone,
                                                   @RequestParam String deliveryType){

        List<ShoppingCart> shoppingCarts = shoppingCartService.showListOfProductsByUserLoginFromShoppingCart(getUserLogin());

        for (ShoppingCart shoppingCart: shoppingCarts) {
            Product product = productService.findProductById(shoppingCart.getProductId());
            orderService.addOrder(new Order(product,customerName,customerAddress, "новый заказ", customerPhone, deliveryType));

        }
        for (ShoppingCart shoppingCart: shoppingCarts) {
            shoppingCartService.deleteProductFromShoppingCartById(shoppingCart.getId());
        }
        model.addAttribute("addedToOrder", true);
        return "index";
    }
// ------------------------------------------------------
@RequestMapping(value = "/shoppingCart/delete/{productName}", method = RequestMethod.GET)
    public String deleteProductFromShoppingCart(@PathVariable (value = "productName") String productName){
    List<ShoppingCart> shoppingCarts = shoppingCartService.showListOfProductsByUserLoginFromShoppingCart(getUserLogin());

    for (ShoppingCart shoppingCart: shoppingCarts) {
        Product product = productService.findProductById(shoppingCart.getProductId());
        if(product.getName().equals(productName)){
            shoppingCartService.deleteProductFromShoppingCartById(shoppingCart.getId());
            break;
        }

    }
    return "redirect:/shoppingCart";

}

// ------------------------------------------------------
    @RequestMapping("/categories")
    public String productTypesPage(Model model) {
        model.addAttribute("justProductTypes", productTypeService.showListOfProductType());
        return "products_and_categories";
    }
    @RequestMapping("/categories/{id}")
    public String productsPageByProductTypes(@PathVariable(value = "id")long productTypeId,
                                            @RequestParam(required = false, defaultValue = "0") Integer page,
                                             Model model) {
        ProductType productType = productTypeService.findById(productTypeId);
        if (page < 0) page = 0;
       List<Product> products = productService
                .showListOfProductsByProductType(productType, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC,"id"));


        model.addAttribute("products",products );
        model.addAttribute("productTypes", productTypeService.showListOfProductType());
        model.addAttribute("byProductTypePages", getPageCount(productType));
        model.addAttribute("productType_id", productTypeId);
        return "products_and_categories";
    }


/* ---------------------
        PAGE COUNTER
 ------------------------ */
    private long getPageCount() {
        long totalCount = productService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

    private long getPageCount(ProductType productType) {
        long totalCount = productService.countByProductType(productType);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }



    private String getUserLogin(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
}

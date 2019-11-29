package com.company.shop.controller;

import com.company.shop.entity.Basket;
import com.company.shop.entity.Product;
import com.company.shop.entity.User;
import com.company.shop.service.BasketService;
import com.company.shop.service.GroupService;
import com.company.shop.service.ProductService;
import com.company.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Main {

    private
    ProductService productService;
    private
    GroupService groupService;
    private
    UserService userService;
    private
    BasketService basketService;

    @Autowired
    public Main(ProductService productService, GroupService groupService, UserService userService, BasketService basketService) {
        this.productService = productService;
        this.groupService = groupService;
        this.userService = userService;
        this.basketService = basketService;
    }

    @RequestMapping("/")
    public ModelAndView greeting() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("groups", groupService.getAllProductGroup());
        return modelAndView;
    }

    @RequestMapping(value = "/getProductsFromGroupById", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> newProd(long id) {
        return groupService.getProductsFromGroupById(id);
    }

    @RequestMapping("/getProduct")
    public Product getProductById(long id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/getUser")
    public User getUserById(@RequestParam(value = "id", defaultValue = "1") long id) {
        return userService.getUserById(id);
    }

    @RequestMapping("getBasketById")
    public Basket getBasketById(long id) {
        return basketService.getBasketById(id);
    }

    @RequestMapping("/addOrDeleteProductInBasket")
    public void addOrDeleteProductInBasket(long idBasket, long idProduct, boolean addOrDelete) {
        basketService.addProductInBasket(idBasket, productService.getProductById(idProduct), addOrDelete);
    }

}

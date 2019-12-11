package com.company.shop.controller;

import com.company.shop.entity.Basket;
import com.company.shop.entity.Product;
import com.company.shop.entity.User;
import com.company.shop.form.UserPropertyForm;
import com.company.shop.service.BasketService;
import com.company.shop.service.GroupService;
import com.company.shop.service.ProductService;
import com.company.shop.service.UserService;
import com.company.shop.validator.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Main {
    @Autowired
    private ValidatorImpl validator;
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

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        Object target = webDataBinder.getTarget();
        if (target.getClass() == UserPropertyForm.class) {
            webDataBinder.setValidator(validator);
        }

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

    @GetMapping("/registration")
    public ModelAndView viewEnterUser() {
        ModelAndView modelAndView = new ModelAndView("registrationPage");
        UserPropertyForm userPropertyForm = new UserPropertyForm();
        modelAndView.addObject("userPropertyForm", userPropertyForm);
        return modelAndView;

    }

    @PostMapping("/registration")
    public String enterUser(Model model,
                            @ModelAttribute("userPropertyForm") @Validated UserPropertyForm userPropertyForm,
                            BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            userService.saveUser(userPropertyForm);
            model.addAttribute("email", userPropertyForm.getEmail());
            return "/results";
        }
        return "registrationPage";

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

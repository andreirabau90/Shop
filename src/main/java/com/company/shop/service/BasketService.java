package com.company.shop.service;

import com.company.shop.entity.Basket;
import com.company.shop.entity.Product;
import com.company.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasketService {

    private final
    IRepository<Basket> basketIRepository;

    @Autowired
    public BasketService(IRepository<Basket> basketIRepository) {
        this.basketIRepository = basketIRepository;
    }

    public Basket getBasketById(long id) {
        return basketIRepository.getById(Basket.class, id);
    }

    public void addProductInBasket(long idBasket, Product product, boolean addOrDelete) {
        Basket basket = getBasketById(idBasket);
        if (addOrDelete) {
            basket.getBasketProducts().add(product);
        } else {
            basket.getBasketProducts().remove(product);
        }
        basketIRepository.saveOrUpdate(basket);
    }

}

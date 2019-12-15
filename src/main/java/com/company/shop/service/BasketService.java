package com.company.shop.service;

import com.company.shop.entity.Basket;
import com.company.shop.entity.Product;
import com.company.shop.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    private final
    BasketRepository basketIRepository;

    @Autowired
    public BasketService(BasketRepository basketIRepository) {
        this.basketIRepository = basketIRepository;
    }

    public Basket getBasketById(long id) {
        return basketIRepository.findById(id).get();
    }

    public void addProductInBasket(long idBasket, Product product, boolean addOrDelete) {
        Basket basket = getBasketById(idBasket);
        if (addOrDelete) {
            basket.getBasketProducts().add(product);
        } else {
            basket.getBasketProducts().remove(product);
        }
        basketIRepository.save(basket);
    }

}

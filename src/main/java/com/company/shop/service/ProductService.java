package com.company.shop.service;

import com.company.shop.repository.IRepository;
import com.company.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class ProductService {
    private final
    IRepository<Product> repository;

    @Autowired
    public ProductService(IRepository<Product> repository) {
        this.repository = repository;
    }

    public Product getProductById(long id) {
        return repository.getById(Product.class, id);


    }
}

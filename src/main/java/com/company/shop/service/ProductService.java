package com.company.shop.service;

import com.company.shop.entity.Product;
import com.company.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).get();
    }
}

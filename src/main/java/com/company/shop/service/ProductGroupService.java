package com.company.shop.service;

import com.company.shop.entity.Product;
import com.company.shop.entity.ProductGroups;
import com.company.shop.repository.ProductGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductGroupService {
    private final
    ProductGroupRepository productGroupRepository;

    @Autowired
    public ProductGroupService(ProductGroupRepository productGroupRepository) {
        this.productGroupRepository = productGroupRepository;
    }

    public ProductGroups getProductGroupById(long id) {
        return productGroupRepository.findById(id).get();
    }

    public List<ProductGroups> getAllProductGroup() {
        return productGroupRepository.findAll();
    }

    public List<Product> getProductsFromGroupById(long id) {
        return productGroupRepository.findById(id).get().getProducts();
    }


}

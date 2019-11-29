package com.company.shop.service;

import com.company.shop.repository.IRepository;
import com.company.shop.entity.Product;
import com.company.shop.entity.ProductGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupService {
    @Autowired
    IRepository<ProductGroups> groupsIRepository;

    public ProductGroups getProductGroupById(long id) {
        return groupsIRepository.getById(ProductGroups.class, id);
    }

    public List<ProductGroups> getAllProductGroup() {
        return groupsIRepository.getAll(ProductGroups.class, "ProductGroups");
    }

    public List<Product> getProductsFromGroupById(long id) {
        return getProductGroupById(id).getProducts();
    }


}

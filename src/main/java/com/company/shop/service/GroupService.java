package com.company.shop.service;

import com.company.shop.repository.IRepository;
import com.company.shop.entity.Product;
import com.company.shop.entity.ProductGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupService {
    private final
    IRepository<ProductGroups> groupsIRepository;

    @Autowired
    public GroupService(IRepository<ProductGroups> groupsIRepository) {
        this.groupsIRepository = groupsIRepository;
    }

    private ProductGroups getProductGroupById(long id) {
        return groupsIRepository.getById(ProductGroups.class, id);
    }

    public List<ProductGroups> getAllProductGroup() {
        return groupsIRepository.getAll( "ProductGroups");
    }

    public List<Product> getProductsFromGroupById(long id) {
        return getProductGroupById(id).getProducts();
    }


}

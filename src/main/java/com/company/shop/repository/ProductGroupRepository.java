package com.company.shop.repository;

import com.company.shop.entity.ProductGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductGroupRepository extends JpaRepository<ProductGroups, Long> {
}

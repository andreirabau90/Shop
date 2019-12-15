package com.company.shop.repository;

import com.company.shop.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}

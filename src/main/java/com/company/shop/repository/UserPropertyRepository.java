package com.company.shop.repository;

import com.company.shop.entity.UserProperty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPropertyRepository extends JpaRepository<UserProperty, Long> {
    UserProperty findByLogin(String login);

    UserProperty findByEmail(String email);
}

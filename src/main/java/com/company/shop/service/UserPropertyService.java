package com.company.shop.service;

import com.company.shop.entity.UserProperty;
import com.company.shop.repository.UserPropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPropertyService {
    private final
    UserPropertyRepository userPropertyRepository;

    @Autowired
    public UserPropertyService(UserPropertyRepository userPropertyRepository) {
        this.userPropertyRepository = userPropertyRepository;
    }


    public UserProperty getByLogin(String login) {
        return userPropertyRepository.findByLogin(login);

    }

    public UserProperty getByEmail(String email) {
        return userPropertyRepository.findByEmail(email);

    }

    public void save(UserProperty userProperty) {
        userPropertyRepository.save(userProperty);
    }
}

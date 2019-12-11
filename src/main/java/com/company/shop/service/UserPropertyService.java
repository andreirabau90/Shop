package com.company.shop.service;

import com.company.shop.entity.UserProperty;
import com.company.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPropertyService {
    private final
    IRepository<UserProperty> userPropertyIRepository;

    @Autowired
    public UserPropertyService(IRepository<UserProperty> userPropertyIRepository) {
        this.userPropertyIRepository = userPropertyIRepository;
    }


    public UserProperty getByLogin(String login) {
        return userPropertyIRepository.getByField(UserProperty.class, "UserProperty", "login", login);

    }

    public UserProperty getByEmail(String email) {
        return userPropertyIRepository.getByField(UserProperty.class, "UserProperty", "email", email);

    }

    public void saveOrUpdate(UserProperty userProperty) {
        userPropertyIRepository.saveOrUpdate(userProperty);
    }
}

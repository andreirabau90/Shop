package com.company.shop.service;

import com.company.shop.repository.IRepository;
import com.company.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    IRepository<User> userIRepository;

    public User getUserById(long id){
        return userIRepository.getById(User.class,id);
    }
}

package com.company.shop.service;

import com.company.shop.entity.User;
import com.company.shop.entity.UserProperty;
import com.company.shop.form.UserPropertyForm;
import com.company.shop.repository.UserPropertyRepository;
import com.company.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final
    UserRepository userRepository;
    private final
    UserPropertyRepository userPropertyRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserPropertyRepository userPropertyRepository) {
        this.userRepository = userRepository;
        this.userPropertyRepository = userPropertyRepository;

    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public void saveUser(UserPropertyForm userPropertyForm) {
        User user = new User(userPropertyForm.getName());
        userRepository.save(user);
        UserProperty userProperty = new UserProperty(userPropertyForm.getLogin(), userPropertyForm.getPassword(), userPropertyForm.getEmail(), user);
        userPropertyRepository.save(userProperty);
    }

}

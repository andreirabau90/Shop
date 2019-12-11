package com.company.shop.service;

import com.company.shop.entity.User;
import com.company.shop.entity.UserProperty;
import com.company.shop.form.UserPropertyForm;
import com.company.shop.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final
    IRepository<User> userIRepository;
    private final
    UserPropertyService userPropertyService;

    @Autowired
    public UserService(IRepository<User> userIRepository, UserPropertyService userPropertyService) {
        this.userIRepository = userIRepository;
        this.userPropertyService = userPropertyService;

    }

    public User getUserById(long id) {
        return userIRepository.getById(User.class, id);
    }

    public void saveUser(UserPropertyForm userPropertyForm) {
        User user = new User(userPropertyForm.getName());
        userIRepository.saveOrUpdate(user);
        UserProperty userProperty = new UserProperty(userPropertyForm.getLogin(), userPropertyForm.getPassword(), userPropertyForm.getEmail(), user);
        userPropertyService.saveOrUpdate(userProperty);
    }

}

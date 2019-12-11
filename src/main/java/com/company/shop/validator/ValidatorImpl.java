package com.company.shop.validator;

import com.company.shop.entity.UserProperty;
import com.company.shop.form.UserPropertyForm;
import com.company.shop.service.UserPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ValidatorImpl implements Validator {
    private final
    UserPropertyService userPropertyService;

    @Autowired
    public ValidatorImpl(UserPropertyService userPropertyService) {
        this.userPropertyService = userPropertyService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserPropertyForm.class;
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserPropertyForm userPropertyForm = (UserPropertyForm) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userPropertyForm.userName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty.userPropertyForm.login");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userPropertyForm.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmedPassword", "NotEmpty.userPropertyForm.confirmedPassword");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userPropertyForm.email");

        if (!errors.hasFieldErrors("login")) {
            if (userPropertyForm.getLogin().length() < 6) {
                errors.rejectValue("login", "Length.userPropertyForm.login");
            }
            UserProperty user = userPropertyService.getByLogin(userPropertyForm.getLogin());
            if (null != user) {
                errors.rejectValue("login", "Duplicate.userPropertyForm.login");
            }
        }
        if (!errors.hasFieldErrors(userPropertyForm.getEmail())) {
            UserProperty user = userPropertyService.getByEmail(userPropertyForm.getEmail());
            if (null != user) {
                errors.rejectValue("email", "Duplicate.userPropertyForm.email");
            }
        }
        if (!errors.hasFieldErrors("password") && !errors.hasFieldErrors("confirmedPassword")) {
            if (!userPropertyForm.getPassword().equals(userPropertyForm.getConfirmedPassword())) {
                errors.rejectValue("confirmedPassword", "Match.userPropertyForm.confirmPassword");
            }
        }
    }
}


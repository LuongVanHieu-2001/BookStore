package com.bookstore.validator;


import com.bookstore.entity.User;
import com.bookstore.repository.IUserRepository;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import com.bookstore.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {


    @Autowired
    private IUserRepository userRepository;


    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {
        if(user == null)
            return true;
        return  user.getId() == null;
    }
}
package com.bookstore.validator;



import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import static  java.lang.annotation.ElementType.*;
import com.bookstore.validator.ValidUsernameValidator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUserIdValidator.class)

public @interface ValidUserId {
    String message() default "Id khong hop le ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default  {};

}

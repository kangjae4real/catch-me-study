package com.catch_me_study.catch_me_study.domain.common.annotation;

import com.catch_me_study.catch_me_study.domain.common.validator.PasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface PasswordMatch {
    String message() default "비밀번호가 일치하지 않습니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String password();

    String confirmPassword();
}

package com.catch_me_study.catch_me_study.domain.common.validator;

import com.catch_me_study.catch_me_study.domain.common.annotation.PasswordMatch;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordValidator implements ConstraintValidator<PasswordMatch, Object> {
    private String passwordField;
    private String confirmPasswordField;
    private String message;

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.passwordField = constraintAnnotation.password();
        this.confirmPasswordField = constraintAnnotation.confirmPassword();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object passwordValue = new BeanWrapperImpl(value).getPropertyValue(passwordField);
        Object confirmPasswordValue = new BeanWrapperImpl(value).getPropertyValue(confirmPasswordField);

        // 둘 다 null이면 다른 validator에서 처리되므로 true 반환
        if (passwordValue == null && confirmPasswordValue == null) {
            return true;
        }

        boolean isValid = passwordValue != null && passwordValue.equals(confirmPasswordValue);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(confirmPasswordField)
                    .addConstraintViolation();
        }

        return isValid;
    }
}

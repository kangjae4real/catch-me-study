package com.catch_me_study.catch_me_study.domain.user.dto;

import com.catch_me_study.catch_me_study.domain.common.annotation.PasswordMatch;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatch(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "비밀번호와 비밀번호 확인이 일치하지 않습니다."
)
public class CreateUserDto extends UserDto {
    @NotBlank
    @Length(max = 120)
    private String password;

    @NotBlank
    @Length(max = 120)
    private String confirmPassword;
}

package com.catch_me_study.catch_me_study.domain.user.dto;

import com.catch_me_study.catch_me_study.domain.common.BaseDto;
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
public class UserDto extends BaseDto {
    @NotBlank
    private String id;

    @NotBlank
    @Length(max = 100)
    private String email;

    @NotBlank
    @Length(max = 100, message = "")
    private String name;
}

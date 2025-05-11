package com.catch_me_study.catch_me_study.domain.user.mapper;

import com.catch_me_study.catch_me_study.domain.user.dto.UserRequestDto;
import com.catch_me_study.catch_me_study.domain.user.dto.UserResponseDto;
import com.catch_me_study.catch_me_study.domain.user.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto toResponseDto(UserEntity userEntity);

    UserEntity toEntity(UserRequestDto userRequestDto);

    List<UserResponseDto> toResponseDto(List<UserEntity> userEntityList);

    List<UserEntity> toEntity(List<UserRequestDto> userRequestDtoList);
}

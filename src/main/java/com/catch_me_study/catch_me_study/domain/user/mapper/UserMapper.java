package com.catch_me_study.catch_me_study.domain.user.mapper;

import com.catch_me_study.catch_me_study.domain.user.dto.UserDto;
import com.catch_me_study.catch_me_study.domain.user.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(UserEntity userEntity);

    UserEntity toEntity(UserDto userDto);

    List<UserDto> toDto(List<UserEntity> userEntityList);

    List<UserEntity> toEntity(List<UserDto> userDtoList);
}

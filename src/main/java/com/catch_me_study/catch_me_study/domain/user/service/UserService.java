package com.catch_me_study.catch_me_study.domain.user.service;

import com.catch_me_study.catch_me_study.domain.user.dto.UserCreateDto;
import com.catch_me_study.catch_me_study.domain.user.dto.UserEditDto;
import com.catch_me_study.catch_me_study.domain.user.dto.UserResponseDto;
import com.catch_me_study.catch_me_study.domain.user.entity.UserEntity;
import com.catch_me_study.catch_me_study.domain.user.mapper.UserMapper;
import com.catch_me_study.catch_me_study.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        UserEntity userEntity = userMapper.toEntity(userCreateDto);

        userEntity.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));

        userRepository.save(userEntity);
        return userMapper.toResponseDto(userEntity);
    }

    public List<UserResponseDto> getAllUser(Optional<Boolean> withDeleted) {
        Boolean withDeletedValue = withDeleted.orElse(false);
        List<UserEntity> userEntityList = withDeletedValue ?
                userRepository.findAll() :
                userRepository.findByIsDeletedFalse();

        return userMapper.toResponseDto(userEntityList);
    }

    private UserEntity findById(String id) {
        Optional<UserEntity> userEntity = userRepository.findByIdAndIsDeletedFalse(id);
        return userEntity.orElseThrow(() -> new RuntimeException("해당 사용자를 찾을 수 없습니다."));
    }

    public UserResponseDto getUserById(String id) {
        return userMapper.toResponseDto(findById(id));
    }

    public UserResponseDto updateUser(UserEditDto userRequestDto) {
        if (userRequestDto.getId() == null || userRequestDto.getId().isEmpty()) {
            throw new IllegalArgumentException("사용자 ID는 필수입니다.");
        }

        UserEntity userEntity = findById(userRequestDto.getId());

        userEntity.update(userRequestDto.getEmail(), userRequestDto.getName());

        userRepository.save(userEntity);

        return userMapper.toResponseDto(userEntity);
    }

    public String deleteUserById(String id) {
        UserEntity userEntity = findById(id);
        userEntity.delete();

        userRepository.save(userEntity);

        return userEntity.getId();
    }
}

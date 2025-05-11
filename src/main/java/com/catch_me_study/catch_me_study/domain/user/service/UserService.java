package com.catch_me_study.catch_me_study.domain.user.service;

import com.catch_me_study.catch_me_study.domain.user.dto.CreateUserDto;
import com.catch_me_study.catch_me_study.domain.user.dto.UserDto;
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

    public UserDto createUser(CreateUserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);

        userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(userEntity);
        return userMapper.toDto(userEntity);
    }

    public List<UserDto> getAllUser(Optional<Boolean> withDeleted) {
        Boolean withDeletedValue = withDeleted.orElse(false);
        List<UserEntity> userEntityList = withDeletedValue ? userRepository.findAll() : userRepository.findByIsDeletedFalse();
        return userMapper.toDto(userEntityList);
    }

    private UserEntity findById(String id) {
        Optional<UserEntity> userEntity = userRepository.findByIdAndIsDeletedFalse(id);
        userEntity.orElseThrow(() -> new RuntimeException("해당 사용자를 찾을 수 없습니다."));

        return userEntity.get();
    }

    public UserDto getUserById(String id) {
        return userMapper.toDto(findById(id));
    }

    public UserDto updateUser(UserDto userDto) {
        UserEntity userEntity = findById(userDto.getId());
        userEntity.update(userEntity.getEmail(), userEntity.getPassword());

        userRepository.save(userEntity);

        return userMapper.toDto(userEntity);
    }

    public String deleteUserById(String id) {
        UserEntity userEntity = findById(id);
        userEntity.delete();

        userRepository.save(userEntity);

        return userEntity.getId();
    }
}

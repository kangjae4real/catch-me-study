package com.catch_me_study.catch_me_study.domain.user.controller;

import com.catch_me_study.catch_me_study.domain.user.dto.UserCreateDto;
import com.catch_me_study.catch_me_study.domain.user.dto.UserEditDto;
import com.catch_me_study.catch_me_study.domain.user.dto.UserResponseDto;
import com.catch_me_study.catch_me_study.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Tag(name = "User", description = "회원 CRUD")
public class UserRestController {
    private final UserService userService;

    @GetMapping
    @Tag(name = "User")
    @Operation(summary = "User 조회", description = "모든 회원을 조회합니다.")
    public List<UserResponseDto> getAllUser(Optional<Boolean> withDeleted) {
        return userService.getAllUser(withDeleted);
    }

    @GetMapping("{id}")
    @Tag(name = "User")
    @Operation(summary = "User 조회", description = "Unique ID를 사용하여 특정 회원을 조회합니다.")
    public UserResponseDto getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @Tag(name = "User")
    @Operation(summary = "User 생성", description = "회원을 생성합니다.")
    public UserResponseDto createUser(@RequestBody @Valid UserCreateDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @PutMapping
    @Tag(name = "User")
    @Operation(summary = "User 수정", description = "Unique ID를 사용하여 특정 회원의 정보를 수정합니다.")
    public UserResponseDto updateUser(@RequestBody @Valid UserEditDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("{id}")
    @Tag(name = "User")
    @Operation(summary = "User 삭제", description = "Unique ID를 사용하여 특정 회원의 정보를 삭제합니다.")
    public String deleteUserById(@PathVariable String id) {
        return userService.deleteUserById(id);
    }
}

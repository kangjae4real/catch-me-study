package com.catch_me_study.catch_me_study.domain.user.controller;

import com.catch_me_study.catch_me_study.domain.user.dto.CreateUserDto;
import com.catch_me_study.catch_me_study.domain.user.dto.UserDto;
import com.catch_me_study.catch_me_study.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUser(Boolean withDeleted) {
        return userService.getAllUser(withDeleted);
    }

    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        return userService.createUser(createUserDto);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody @Valid UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable String id) {
        return userService.deleteUserById(id);
    }
}

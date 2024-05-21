package net.protsenko.web.controller;

import lombok.RequiredArgsConstructor;
import net.protsenko.domain.User;
import net.protsenko.service.UserService;
import net.protsenko.web.dto.UserDto;
import net.protsenko.web.mapper.UserMapper;
import net.protsenko.web.validation.OnUpdate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Validated
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @PutMapping
    public UserDto updateUser(@Validated(OnUpdate.class) @RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id) {
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(id);
    }

}

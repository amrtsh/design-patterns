package org.example.twitterapplication.controller;

import org.example.twitterapplication.dto.CreateUserDto;
import org.example.twitterapplication.dto.UserDto;
import org.example.twitterapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userDtoList = userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(userDtoList);
    }

    @GetMapping("/getById/{userId}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer userId) {
        UserDto userDto = userService.getById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @GetMapping("/getByIdWithFullData/{userId}")
    public ResponseEntity<UserDto> getByIdWithFullData(@PathVariable Integer userId) {
        UserDto userDto = userService.getByIdWithFullData(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        CreateUserDto createdUser = userService.createUser(createUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        UserDto user = userService.updateUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteById(userId);
    }
}

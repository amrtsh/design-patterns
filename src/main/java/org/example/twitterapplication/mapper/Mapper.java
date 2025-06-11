package org.example.twitterapplication.mapper;

import lombok.Data;
import org.example.twitterapplication.domain.model.User;
import org.example.twitterapplication.dto.CreateUserDto;
import org.example.twitterapplication.dto.UserDto;
import org.example.twitterapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Mapper {
    @Autowired
    private UserService userService;

    public static User toDomain(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .timezone(userDto.getTimezone())
                .build();
    }

    public static User toDomain(CreateUserDto createUserDto) {
        return User.builder()
                .name(createUserDto.getName())
                .email(createUserDto.getEmail())
                .timezone(createUserDto.getTimezone())
                .build();
    }

    public UserDto toBasicDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .timezone(user.getTimezone())
                .build();
    }

    public CreateUserDto createBasicDto(User user) {
        return CreateUserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .timezone(user.getTimezone())
                .build();
    }

    public UserDto toFullDto(User user) {
        List<User> followers = userService.getFollowers(user.getId());
        List<User> followings = userService.getFollowing(user.getId());
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .timezone(user.getTimezone())
                .followers(followers)
                .followings(followings)
                .build();
    }
}

package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.User;
import org.example.twitterapplication.domain.model.UserFollow;
import org.example.twitterapplication.dto.CreateUserDto;
import org.example.twitterapplication.dto.UserDto;
import org.example.twitterapplication.mapper.Mapper;
import org.example.twitterapplication.repository.UserFollowRepository;
import org.example.twitterapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.stream.Collectors;

@Service
@ApplicationScope
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFollowRepository userFollowRepository;
    @Autowired
    private Mapper mapper;

    public List<User> getFollowers(Integer integerId) {
        List<UserFollow> followRelations = userFollowRepository.findByTargetUserId(integerId);
        List<Integer> followerIds = followRelations.stream()
                .map(UserFollow::getUserId)
                .collect(Collectors.toList());
        return userRepository.findAllById(followerIds);
    }

    public List<User> getFollowing(Integer integerId) {
        List<UserFollow> followRelations = userFollowRepository.findByUserId(integerId);
        List<Integer> followingIds = followRelations.stream()
                .map(UserFollow::getTargetUserId)
                .collect(Collectors.toList());
        return userRepository.findAllById(followingIds);
    }

    public CreateUserDto createUser(CreateUserDto createUserDto) {
        User user = Mapper.toDomain(createUserDto);
        User savedUser = userRepository.save(user);
        CreateUserDto userBasicDto = mapper.createBasicDto(savedUser);
        return userBasicDto;
    }

    public UserDto updateUser(UserDto userDto) {
        User user = Mapper.toDomain(userDto);
        return mapper.toFullDto(userRepository.save(user));
    }

    public UserDto getById(Integer integer) {
        User user = userRepository.findById(integer)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapper.toBasicDto(user);
    }

    public UserDto getByIdWithFullData(Integer integer) {
        User user = userRepository.findById(integer)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return mapper.toFullDto(user);
    }

    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::toFullDto)
                .toList();
    }

    public void deleteById(Integer integer) {
        userRepository.deleteById(integer);
    }
}

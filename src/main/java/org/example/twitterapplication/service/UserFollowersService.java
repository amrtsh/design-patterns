package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.UserFollowers;
import org.example.twitterapplication.repository.UserFollowersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class UserFollowersService implements CustomService<UserFollowers, Integer> {
    @Autowired
    private UserFollowersRepository userFollowersRepository;

    @Override
    public UserFollowers create(UserFollowers entity) {
        return userFollowersRepository.save(entity);
    }

    @Override
    public UserFollowers update(UserFollowers entity) {
        return userFollowersRepository.save(entity);
    }

    @Override
    public UserFollowers getById(Integer integer) {
        return userFollowersRepository.findById(integer).orElseThrow(() -> new EntityNotFoundException("User Followers not found"));
    }

    @Override
    public List<UserFollowers> getAll() {
        return userFollowersRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        userFollowersRepository.deleteById(integer);
    }
}

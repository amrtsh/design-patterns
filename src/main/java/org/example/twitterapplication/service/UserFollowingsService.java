package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.UserFollowings;
import org.example.twitterapplication.repository.UserFollowingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class UserFollowingsService implements CustomService<UserFollowings, Integer> {
    @Autowired
    private UserFollowingsRepository userFollowingsRepository;

    @Override
    public UserFollowings create(UserFollowings entity) {
        return userFollowingsRepository.save(entity);
    }

    @Override
    public UserFollowings update(UserFollowings entity) {
        return userFollowingsRepository.save(entity);
    }

    @Override
    public UserFollowings getById(Integer integer) {
        return userFollowingsRepository.findById(integer).orElseThrow(() -> new EntityNotFoundException("User Followings not found"));
    }

    @Override
    public List<UserFollowings> getAll() {
        return userFollowingsRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        userFollowingsRepository.deleteById(integer);
    }
}


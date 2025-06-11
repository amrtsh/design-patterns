package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.UserFollow;
import org.example.twitterapplication.repository.UserFollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class UserFollowService {
    @Autowired
    private UserFollowRepository userFollowRepository;

    public UserFollow create(UserFollow entity) {
        return userFollowRepository.save(entity);
    }

    public UserFollow update(UserFollow entity) {
        return userFollowRepository.save(entity);
    }

    public UserFollow getById(Integer integer) {
        return userFollowRepository.findById(integer).orElseThrow(() -> new EntityNotFoundException("User Followers not found"));
    }

    public List<UserFollow> getAll() {
        return userFollowRepository.findAll();
    }

    public void deleteById(Integer integer) {
        userFollowRepository.deleteById(integer);
    }
}

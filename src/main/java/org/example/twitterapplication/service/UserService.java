package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.User;
import org.example.twitterapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class UserService implements CustomService<User, Integer> {
    private UserRepository userRepository;

    @Override
    public User create(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User getById(Integer integer) {
        return userRepository.findById(integer).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        userRepository.deleteById(integer);
    }
}

package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.Poll;
import org.example.twitterapplication.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class PollService implements CustomService<Poll, Integer> {
    @Autowired
    private PollRepository pollRepository;

    @Override
    public Poll create(Poll entity) {
        return pollRepository.save(entity);
    }

    @Override
    public Poll update(Poll entity) {
        return pollRepository.save(entity);
    }

    @Override
    public List<Poll> getAll() {
        return pollRepository.findAll();
    }

    @Override
    public Poll getById(Integer id) {
        return pollRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Poll not found"));
    }

    @Override
    public void deleteById(Integer id) {
        pollRepository.deleteById(id);
    }
}

package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.PollOption;
import org.example.twitterapplication.repository.PollOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class PollOptionService implements CustomService<PollOption, Integer> {
    @Autowired
    private PollOptionRepository pollOptionRepository;

    @Override
    public PollOption create(PollOption entity) {
        return pollOptionRepository.save(entity);
    }

    @Override
    public PollOption update(PollOption entity) {
        return pollOptionRepository.save(entity);
    }

    @Override
    public PollOption getById(Integer integer) {
        return pollOptionRepository.findById(integer).orElseThrow(() -> new EntityNotFoundException("PollOption not found"));
    }

    @Override
    public List<PollOption> getAll() {
        return pollOptionRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        pollOptionRepository.deleteById(integer);
    }
}

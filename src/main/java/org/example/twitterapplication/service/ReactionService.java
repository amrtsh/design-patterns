package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.Reaction;
import org.example.twitterapplication.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class ReactionService implements CustomService<Reaction, Integer> {
    @Autowired
    private ReactionRepository reactionRepository;

    @Override
    public Reaction create(Reaction entity) {
        return reactionRepository.save(entity);
    }

    @Override
    public Reaction update(Reaction entity) {
        return reactionRepository.save(entity);
    }

    @Override
    public Reaction getById(Integer integer) {
        return reactionRepository.findById(integer).orElseThrow(() -> new EntityNotFoundException("Reaction not found"));
    }

    @Override
    public List<Reaction> getAll() {
        return reactionRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        reactionRepository.deleteById(integer);
    }
}

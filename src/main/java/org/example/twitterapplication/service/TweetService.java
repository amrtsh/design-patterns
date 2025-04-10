package org.example.twitterapplication.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.twitterapplication.domain.model.Tweet;
import org.example.twitterapplication.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class TweetService implements CustomService<Tweet, Integer> {
    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public Tweet create(Tweet entity) {
        return tweetRepository.save(entity);
    }

    @Override
    public Tweet update(Tweet entity) {
        return tweetRepository.save(entity);
    }

    @Override
    public Tweet getById(Integer integer) {
        return tweetRepository.findById(integer).orElseThrow(() -> new EntityNotFoundException("Tweet not found"));
    }

    @Override
    public List<Tweet> getAll() {
        return tweetRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        tweetRepository.deleteById(integer);
    }
}

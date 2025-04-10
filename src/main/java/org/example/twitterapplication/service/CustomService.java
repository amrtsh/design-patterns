package org.example.twitterapplication.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public interface CustomService<T, ID> {
    T create(T entity);

    T update(T entity);

    T getById(ID id);

    List<T> getAll();

    void deleteById(ID id);
}

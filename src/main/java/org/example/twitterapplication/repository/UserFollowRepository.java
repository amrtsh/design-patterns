package org.example.twitterapplication.repository;

import org.example.twitterapplication.domain.model.UserFollow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFollowRepository extends JpaRepository<UserFollow, Integer> {
    // Скільки людей підписані на userId (тобто він для них – following)
    List<UserFollow> findByTargetUserId(Integer targetUserId);

    // Скільки людей userId підписав (тобто він – підписник)
    List<UserFollow> findByUserId(Integer userId);
}

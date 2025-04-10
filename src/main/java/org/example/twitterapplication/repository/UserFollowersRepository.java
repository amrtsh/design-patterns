package org.example.twitterapplication.repository;

import org.example.twitterapplication.domain.model.UserFollowers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFollowersRepository extends JpaRepository<UserFollowers, Integer> {
}

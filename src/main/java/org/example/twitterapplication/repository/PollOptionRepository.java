package org.example.twitterapplication.repository;

import org.example.twitterapplication.domain.model.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollOptionRepository extends JpaRepository<PollOption, Integer> {
}

package org.example.twitterapplication.domain.model;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(UserFollowersId.class)
public class UserFollowers {
    @Id
    @NotNull
    @CsvBindByName(column = "user_id")
    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Id
    @NotNull
    @CsvBindByName(column = "follower_id")
    @Column(name = "follower_id", nullable = false)
    private Integer follower_id;
}


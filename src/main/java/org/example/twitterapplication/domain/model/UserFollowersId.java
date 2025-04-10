package org.example.twitterapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowersId implements Serializable {
    private Integer user_id;
    private Integer follower_id;
}

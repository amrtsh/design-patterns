package org.example.twitterapplication.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowId implements Serializable {
    private Integer userId;
    private Integer targetUserId;
}

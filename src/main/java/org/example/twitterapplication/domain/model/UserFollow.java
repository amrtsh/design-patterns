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


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(UserFollowId.class)
public class UserFollow {
    @Id
    @CsvBindByName(column = "user_id")
    @Column(name = "user_id")
    private Integer userId; //who

    @Id
    @CsvBindByName(column = "target_user_id")
    @Column(name = "target_user_id")
    private Integer targetUserId; //to whom
}


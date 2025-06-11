package org.example.twitterapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.twitterapplication.domain.model.User;

import java.time.ZoneId;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private ZoneId timezone;
    private List<User> followers;
    private List<User> followings;
}

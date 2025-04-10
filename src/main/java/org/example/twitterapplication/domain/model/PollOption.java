package org.example.twitterapplication.domain.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class PollOption {
    @Id
    @NotNull
    @CsvIgnore
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CsvBindByName(column = "text")
    private String text;

    @CsvBindByName(column = "voteCount")
    private int voteCount;

    @CsvBindByName(column = "poll_id")
    private Integer poll_id;
}

package org.example.twitterapplication.domain.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
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
import org.example.twitterapplication.domain.converter.LocalDateTimeConverter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tweet {
    @Id
    @NotNull
    @CsvIgnore
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @CsvBindByName(column = "text")
    private String text;

    @NotNull
    @CsvCustomBindByName(column = "timestamp", converter = LocalDateTimeConverter.class)
    private LocalDateTime timestamp;

    @CsvBindByName(column = "author_id")
    private Integer author_id;

    @CsvBindByName(column = "poll_id")
    private Integer poll_id;
}

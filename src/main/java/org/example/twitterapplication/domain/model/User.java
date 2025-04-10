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
import org.example.twitterapplication.domain.converter.ZoneIdConverter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @NotNull
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvIgnore
    private Integer id;

    @NotNull
    @CsvBindByName(column = "name")
    @Column(name = "name")
    private String name;

    @NotNull
    @Email
    @CsvBindByName(column = "email")
    @Column(name = "email")
    private String email;

    @CsvBindByName(column = "timezone")
    @CsvCustomBindByName(converter = ZoneIdConverter.class)
    private ZoneId timezone;
}

package org.example.twitterapplication.domain.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter extends AbstractBeanField<LocalDateTime, String> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    protected LocalDateTime convert(String value) throws CsvDataTypeMismatchException {
        try {
            return LocalDateTime.parse(value, formatter);
        } catch (Exception e) {
            throw new CsvDataTypeMismatchException("Unable to parse LocalDateTime: " + value, LocalDateTime.class, e.getMessage());
        }
    }
}

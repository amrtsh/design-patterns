package org.example.twitterapplication.domain.converter;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.ZoneId;

public class ZoneIdConverter extends AbstractBeanField<ZoneId, String> {
    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        try {
            return ZoneId.of(value.trim());
        } catch (Exception e) {
            throw new CsvDataTypeMismatchException("Invalid ZoneId: " + value);
        }
    }
}

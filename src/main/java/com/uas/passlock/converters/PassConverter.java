package com.uas.passlock.converters;

import com.uas.passlock.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Component
public class PassConverter implements AttributeConverter<String, String> {

    @Autowired
    private SecurityUtil securityUtil;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return securityUtil.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return securityUtil.decrypt(dbData);
    }
}

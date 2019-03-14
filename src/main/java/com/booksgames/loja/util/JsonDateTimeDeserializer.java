package com.booksgames.loja.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JsonDateTimeDeserializer extends JsonDeserializer<Date> {

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Override
    public Date deserialize(final JsonParser jp,
                            final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        if (jp.getCurrentToken().equals(JsonToken.VALUE_STRING)) {
            try {
                Date datetime = format.parse(jp.getText().toString());
                return datetime;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
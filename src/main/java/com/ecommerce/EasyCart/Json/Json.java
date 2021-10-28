package com.ecommerce.EasyCart.Json;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public final class Json {

    public static final String TIME_ZONE = "UTC";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Retention(RetentionPolicy.RUNTIME)
    @JacksonAnnotationsInside
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT, timezone = TIME_ZONE)
    public @interface DateFormat {

		

		String pattern();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @JacksonAnnotationsInside
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT, timezone = TIME_ZONE)
    public static @interface DateTimeFormat {

    }

    private Json() {
    }
    
    //@Override
   /* public byte[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
     String text = p.getText();
     try {
      return Base64.getDecoder().decode(text);
     } catch (IllegalArgumentException e) {
      throw new InvalidFormatException(p, "Expected a base64 encoded byte array", text, Instant.class);
     }
    }*/
}


package com.aspectConcepts.aspect_oriented.service;

import com.aspectConcepts.aspect_oriented.aspects.Loggable;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeService {

    private static final DateTimeFormatter FORMATTER_24 = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final DateTimeFormatter FORMATTER_12 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    @Value("#{'${spring.profiles.active}' == 'local'}")
    private boolean is24;

    public TimeService(){super();}

    @Loggable
    public String getCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        if(is24)
            return FORMATTER_24.format(now);
        return  FORMATTER_12.format(now);
    }
}

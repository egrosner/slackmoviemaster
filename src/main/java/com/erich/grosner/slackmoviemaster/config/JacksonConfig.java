package com.erich.grosner.slackmoviemaster.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Configuration;

/**
 * Created by egros on 6/25/2017.
 */
@Configuration
public class JacksonConfig {
    private void setupOM(ObjectMapper om) {
        om.registerModule(new JavaTimeModule());
    }
}

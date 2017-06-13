package com.erich.grosner.slackmoviemaster.config;

import com.erich.grosner.slackmoviemaster.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by egros on 6/8/2017.
 */
@Configuration
public class ResponseConfig {
    @Bean
    public List<Response> getResponses() throws URISyntaxException, IOException {
        File quotes = new ClassPathResource("terminator.json").getFile();

        ObjectMapper om = new ObjectMapper();
        List<Response> responses = om.readValue(quotes, TypeFactory.defaultInstance().constructCollectionType(List.class, Response.class));

        return responses;
    }
}

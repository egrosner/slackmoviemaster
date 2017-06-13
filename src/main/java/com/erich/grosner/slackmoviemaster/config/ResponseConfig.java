package com.erich.grosner.slackmoviemaster.config;

import com.erich.grosner.slackmoviemaster.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by egros on 6/8/2017.
 */
@Configuration
public class ResponseConfig {
    @Bean
    public List<Response> getResponses() throws URISyntaxException, IOException {
        URI quotes = new ClassPathResource("terminator.json").getURI();
        String contents = new String(Files.readAllBytes(Paths.get(quotes)));

        ObjectMapper om = new ObjectMapper();
        List<Response> responses = om.readValue(contents, TypeFactory.defaultInstance().constructCollectionType(List.class, Response.class));

        return responses;
    }
}

package com.erich.grosner.slackmoviemaster.config;

import com.erich.grosner.slackmoviemaster.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.io.Resources;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by egros on 6/8/2017.
 */
@Configuration
public class ResponseConfig {
    @Bean
    public List<Response> getResponses() throws URISyntaxException, IOException {
        URL quotes = Resources.getResource("terminator.json");
        String contents = Resources.toString(quotes, Charset.defaultCharset());

        ObjectMapper om = new ObjectMapper();
        List<Response> responses = om.readValue(contents, TypeFactory.defaultInstance().constructCollectionType(List.class, Response.class));

        return responses;
    }
}

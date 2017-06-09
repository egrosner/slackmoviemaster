package com.erich.grosner.slackmoviemaster.config;

import com.erich.grosner.slackmoviemaster.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.common.io.Resources;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * Created by egros on 6/8/2017.
 */
@Configuration
public class ResponseConfig {
    @Bean
    public List<Response> getResponses() throws URISyntaxException, IOException {
        URI messages = Resources.getResource("terminator.json").toURI();
        File f = Paths.get(messages).toFile();

        ObjectMapper om = new ObjectMapper();
        List<Response> responses = om.readValue(f, TypeFactory.defaultInstance().constructCollectionType(List.class, Response.class));

        return responses;
    }
}

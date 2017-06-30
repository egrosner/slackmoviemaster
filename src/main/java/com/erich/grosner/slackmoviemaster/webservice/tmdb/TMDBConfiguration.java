package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.erich.grosner.slackmoviemaster.properties.TMDBProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by egros on 6/7/2017.
 */
@Configuration
public class TMDBConfiguration {
    @Bean
    public TMDBApi getTMDBApi(TMDBProperties tmdbProperties, ObjectMapper objectMapper) {
        //objectMapper.registerModule(new JavaTimeModule());
        return Feign.builder().decoder(new JacksonDecoder(objectMapper)).target(TMDBApi.class, tmdbProperties.getUrl());
    }
}

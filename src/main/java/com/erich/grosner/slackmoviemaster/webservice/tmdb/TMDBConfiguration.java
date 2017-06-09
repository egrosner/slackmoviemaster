package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.erich.grosner.slackmoviemaster.properties.TMDBProperties;
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
    public TMDBApi getTMDBApi(TMDBProperties tmdbProperties) {
        return Feign.builder().decoder(new JacksonDecoder()).target(TMDBApi.class, tmdbProperties.getUrl());
    }
}

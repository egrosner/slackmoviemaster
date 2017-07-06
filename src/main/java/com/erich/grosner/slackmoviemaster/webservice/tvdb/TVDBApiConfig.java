package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by egros on 7/4/2017.
 */
@Configuration
public class TVDBApiConfig {
    @Bean
    public TVDBApi getTVDBApi(TVDBApiProperties tvdbApiProperties, ObjectMapper objectMapper) {
        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .target(TVDBApi.class, tvdbApiProperties.getUrl());
    }
}

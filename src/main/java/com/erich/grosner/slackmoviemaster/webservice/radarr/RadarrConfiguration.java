package com.erich.grosner.slackmoviemaster.webservice.radarr;

import com.erich.grosner.slackmoviemaster.properties.RadarrProperties;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by egros on 6/7/2017.
 */
@Component
public class RadarrConfiguration {
    @Bean
    public RadarrAPI getRadarrAPI(RadarrProperties radarrProperties) {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(RadarrAPI.class, radarrProperties.getUrl());
    }
}

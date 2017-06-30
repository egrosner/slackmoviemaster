package com.erich.grosner.slackmoviemaster.config;

import com.erich.grosner.slackmoviemaster.properties.SlackBotProperties;
import com.erich.grosner.slackmoviemaster.webservice.slack.SlackWebHook;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by egros on 6/28/2017.
 */
@Configuration
public class SlackWebHookConfig {
    @Bean
    public SlackWebHook getSlackWebHook(SlackBotProperties slackBotProperties, ObjectMapper mapper) {
        return Feign.builder()
                .encoder(new JacksonEncoder(mapper))
                .decoder(new JacksonDecoder(mapper))
                .target(SlackWebHook.class, slackBotProperties.getWebhookUrl());
    }
}

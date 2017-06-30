package com.erich.grosner.slackmoviemaster.properties;

/**
 * Created by egros on 6/8/2017.
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "slack.bot")
@Configuration
@Data
public class SlackBotProperties {
    private String token;
    private String webhookUrl;
    private String webhookToken;
}

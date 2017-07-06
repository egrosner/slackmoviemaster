package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by egros on 7/4/2017.
 */
@Configuration
@ConfigurationProperties(prefix = "tvdb.api")
@Data
public class TVDBApiProperties {
    private String key;
    private String userkey;
    private String url;
    private String username;
}

package com.erich.grosner.slackmoviemaster.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by egros on 6/7/2017.
 */
@ConfigurationProperties(prefix = "radarr.api")
@Configuration
@Data
public class RadarrProperties {
    private String key;
    private String url;
}

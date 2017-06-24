package com.erich.grosner.slackmoviemaster.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by egros on 6/23/2017.
 */
@Data
public class SonarrEpisode {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("EpisodeNumber")
    private int episodeNumber;
    @JsonProperty("SeasonNumber")
    private int seasonNumber;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("AirDate")
    private LocalDate airDate;
    @JsonProperty("AirDateUtc")
    private LocalDateTime airDateUtc;
    @JsonProperty("Quality")
    private String quality;
    @JsonProperty("QualityVersion")
    private int qualityVersion;
    @JsonProperty("ReleaseGroup")
    private String releaseGroup;
    @JsonProperty("SceneName")
    private String sceneName;
}

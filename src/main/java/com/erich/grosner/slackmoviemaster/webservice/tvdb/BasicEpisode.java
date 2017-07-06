package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by egros on 7/4/2017.
 */
@Data
public class BasicEpisode {
    @JsonProperty("absoluteNumber")
    private int absoluteNumber;
    @JsonProperty("airedEpisodeNumber")
    private int airedEpisodeNumber;
    @JsonProperty("airedSeason")
    private int airedSeason;
    @JsonProperty("dvdEpisodeNumber")
    private int dvdEpisodeNumber;
    @JsonProperty("dvdSeason")
    private int dvdSeason;
    @JsonProperty("episodeName")
    private String episodeName;
    @JsonProperty("firstAired")
    private String firstAired;
    private int id;
    @JsonProperty("lastUpdated")
    private int lastUpdated;
    private String overview;
}

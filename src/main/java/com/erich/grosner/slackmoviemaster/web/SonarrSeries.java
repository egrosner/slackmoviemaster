package com.erich.grosner.slackmoviemaster.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by egros on 6/23/2017.
 */
@Data
public class SonarrSeries {
    @JsonProperty("Id")
    private int id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Path")
    private String path;
    @JsonProperty("TvdbId")
    private int tvdbId;
}
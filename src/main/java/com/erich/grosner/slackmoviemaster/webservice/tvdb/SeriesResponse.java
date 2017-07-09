package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by egros on 7/1/2017.
 */
@Data
public class SeriesResponse {

    private SeriesData data;
    private TVDBErrors errors;

    @Data
    public static class SeriesData {
        private String added;
        @JsonProperty("airsDayOfWeek")
        private String airsDayOfWeek;
        @JsonProperty("airsTime")
        private String airsTime;
        private List<String> aliases;
        private String banner;
        @JsonProperty("firstAired")
        private String firstAired;
        private List<String> genre;
        private int id;
        @JsonProperty("imdbId")
        private String imdbId;
        @JsonProperty("lastUpdated")
        private int lastUpdated;
        private String network;
        @JsonProperty("networkId")
        private String networkId;
        private String overview;
        private String rating;
        private String runtime;
        @JsonProperty("seriesId")
        private String seriesId;
        @JsonProperty("seriesName")
        private String seriesName;
        @JsonProperty("siteRating")
        private int siteRating;
        @JsonProperty("siteRatingCount")
        private int siteRatingCount;
        private String status;
        @JsonProperty("zap2itId")
        private String zap2itId;
    }
}

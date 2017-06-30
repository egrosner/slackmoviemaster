package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by egros on 6/29/2017.
 */
@Data
public class TMDBSeasonEpisodeResponse {

    @JsonProperty("air_date")
    private LocalDate airDate;
    private List<TMDBCrew> crew;
    @JsonProperty("episode_number")
    private int episodeNumber;
    @JsonProperty("guest_stars")
    private List<TMDBGuestStar> guestStars;
    private String name;
    private String overview;
    private int id;
    @JsonProperty("production_code")
    private String productionCode;
    @JsonProperty("season_number")
    private int seasonNumber;
    @JsonProperty("still_path")
    private String stillPath;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;

    @Data
    public static class TMDBCrew {
        private int id;
        @JsonProperty("credit_id")
        private String creditId;
        private String name;
        private String department;
        private String job;
        @JsonProperty("profile_path")
        private String profilePath;
    }

    @Data
    public static class TMDBGuestStar {
        private int id;
        private String name;
        @JsonProperty("credit_id")
        private String creditId;
        private String character;
        private int order;
        @JsonProperty("profile_path")
        private String profilePath;
    }
}

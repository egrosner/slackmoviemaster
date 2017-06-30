package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by egros on 6/26/2017.
 */
@Data
public class TMDBFindTvResult {
    @JsonProperty("backdrop_path")
    private String backdropPath;
    @JsonProperty("first_air_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate firstAirDate;
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;
    private int id;
    @JsonProperty("original_language")
    private String originalLanguage;
    @JsonProperty("original_name")
    private String originalName;
    private String overview;
    @JsonProperty("origin_country")
    private List<String> originCountry;
    @JsonProperty("poster_path")
    private String posterPath;
    private double popularity;
    private String name;
    @JsonProperty("vote_average")
    private double voteAverage;
    @JsonProperty("vote_count")
    private int voteCount;
}

package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by egros on 6/26/2017.
 */
@Data
public class TMDBFindResponse {
    @JsonProperty("movie_results")
    private List<Object> movieResults;
    @JsonProperty("person_results")
    private List<Object> personResults;
    @JsonProperty("tv_results")
    private List<TMDBFindTvResult> tvResults;
    @JsonProperty("tv_episode_results")
    private List<Object> tvEpisodeResults;
    @JsonProperty("tv_season_results")
    private List<Object> tvSeasonResults;
}

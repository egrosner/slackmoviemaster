package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import lombok.Data;

import java.util.List;

/**
 * Created by egros on 7/4/2017.
 */
@Data
public class SeriesEpisodesResponse {
    private List<BasicEpisode> data;
    private TVDBErrors errors;
    private Links links;
}

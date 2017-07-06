package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import lombok.Data;

/**
 * Created by egros on 7/5/2017.
 */
@Data
public class EpisodeResponse {
    private FullEpisode data;
    private TVDBErrors errors;
}

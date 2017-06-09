package com.erich.grosner.slackmoviemaster.webservice.radarr;

import lombok.Data;

/**
 * Created by egros on 6/7/2017.
 */
@Data
public class MovieAddOptions {
    private boolean ignoreEpisodesWithFiles = false;
    private boolean ignoreEpisodesWithoutFiles = false;
    private boolean searchForMovie = false;
}

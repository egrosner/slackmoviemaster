package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by egros on 7/5/2017.
 */
@RequiredArgsConstructor
public enum SeriesEpisodeHeaders {
    AIRED_SEASON("airedSeason"),
    AIRED_EPISODE("airedEpisode");

    @Getter
    private final String name;

    public String toString() {
        return name;
    }
}

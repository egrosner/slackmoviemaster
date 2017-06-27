package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by egros on 6/23/2017.
 */
@RequiredArgsConstructor
public enum ExternalSource {
    IMDB_ID("imdb_id"),
    FREEBASE_MID("freebase_mid"),
    FREEBASE_ID("freebase_id"),
    TVDB_ID("tvdb_id"),
    TVRAGE_ID("tvrage_id");

    @Getter(onMethod = @__(@JsonValue))
    private final String name;
}

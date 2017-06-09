package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

/**
 * Created by egros on 6/7/2017.
 */
public interface TMDBApi {
    @RequestLine("GET /find/{externalId}?external_source=imdb_id&api_key={apiKey}")
    JsonNode find(@Param("externalId") String externalId, @Param("apiKey") String apiKey);
}

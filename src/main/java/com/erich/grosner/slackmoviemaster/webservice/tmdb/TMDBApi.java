package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Param;
import feign.RequestLine;

/**
 * Created by egros on 6/7/2017.
 */
public interface TMDBApi {
    @RequestLine("GET /find/{externalId}?external_source={externalSource}&api_key={apiKey}")
    JsonNode find(@Param("externalId") String externalId,
                  @Param("externalSource") ExternalSource externalSource,
                  @Param("apiKey") String apiKey);
}

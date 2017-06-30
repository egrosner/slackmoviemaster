package com.erich.grosner.slackmoviemaster.webservice.tmdb;

import feign.Param;
import feign.RequestLine;

/**
 * Created by egros on 6/7/2017.
 */
public interface TMDBApi {
    @RequestLine("GET /find/{externalId}?external_source={externalSource}&api_key={apiKey}")
    TMDBFindResponse find(@Param("externalId") String externalId,
                          @Param("externalSource") ExternalSource externalSource,
                          @Param("apiKey") String apiKey);

    @RequestLine("GET /tv/{tmdbId}/season/{seasonNumber}/episode/{episodeNumber}?api_key={apiKey}")
    TMDBSeasonEpisodeResponse getSeasonEpisode(@Param("tmdbId") String tmdbId,
                                               @Param("seasonNumber") String seasonNumber,
                                               @Param("episodeNumber") String episodeNumber,
                                               @Param("apiKey") String apiKey);
}

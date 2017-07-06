package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

/**
 * Created by egros on 7/1/2017.
 */
@Headers("Content-Type: application/json")
public interface TVDBApi {
    @RequestLine("POST /login")
    LoginResponse login(LoginRequest request);

    @RequestLine("GET /series/{id}")
    @Headers("Authorization: Bearer {authToken}")
    SeriesResponse series(@Param("id") String id, @Param("authToken") String authToken);

    @RequestLine("GET /series/{id}/episodes/query?airedSeason={seasonNumber}&airedEpisode={episodeNumber}")
    @Headers("Authorization: Bearer {authToken}")
    SeriesEpisodesResponse queryBySeasonEpisode(@Param("id") String id,
                                                @QueryMap Map<String, Object> queryParams,
                                                @Param("authToken") String authToken);

    @RequestLine("GET /episodes/{id}")
    @Headers("Authorization: Bearer {authToken}")
    EpisodeResponse queryByEpisodeId(@Param("id") String id,
                                     @Param("authToken") String authToken);
}

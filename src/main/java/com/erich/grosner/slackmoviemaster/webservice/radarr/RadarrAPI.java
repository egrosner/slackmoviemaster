package com.erich.grosner.slackmoviemaster.webservice.radarr;

import com.fasterxml.jackson.databind.JsonNode;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Request;

/**
 * Created by egros on 6/7/2017.
 */
public interface RadarrAPI {
    @RequestLine("GET /movie")
    JsonNode getAllMovies();

    @RequestLine("GET /movies/lookup?term={imdbId}")
    @Headers("X-Api-Key: {apikey}")
    List<Movie> searchByImdbId(@Param("imdbId") String imdbId, @Param("apikey") String apikey);

    @RequestLine("POST /movie")
    @Headers("X-Api-Key: {apikey}")
    JsonNode addMovie(Movie movie, @Param("apikey") String apikey);
}

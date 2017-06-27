package com.erich.grosner.slackmoviemaster.web;

import com.erich.grosner.slackmoviemaster.properties.TMDBProperties;
import com.erich.grosner.slackmoviemaster.webservice.tmdb.ExternalSource;
import com.erich.grosner.slackmoviemaster.webservice.tmdb.TMDBApi;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by egros on 6/8/2017.
 */
@RestController
public class WebController {

    @Autowired
    private TMDBApi tmdbApi;

    @Autowired
    private TMDBProperties tmdbProperties;

    @GetMapping
    public String start() {
        return "booting up...";
    }

    //intercept from radarr / sonarr
    @PostMapping("/test")
    public String receive(@RequestBody SonarrRequest sonarrRequest) {

        return "OK";
    }

    @PostMapping("/sonarr")
    public String receiveFromSonarr(@RequestBody SonarrRequest sonarrRequest) {
        //what event type is it?
        if(sonarrRequest.getEventType() != SonarrEventType.DOWNLOAD) {
            //do nothing for now
            return "OK";
        }

        //find tmdb information
        JsonNode jsonResult = tmdbApi.find(sonarrRequest.getSeries().getTvdbId() + "", ExternalSource.TVDB_ID, tmdbProperties.getKey());

        return "OK";
    }

}

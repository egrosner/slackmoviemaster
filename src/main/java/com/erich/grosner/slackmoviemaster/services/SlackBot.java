package com.erich.grosner.slackmoviemaster.services;

import com.erich.grosner.slackmoviemaster.model.Response;
import com.erich.grosner.slackmoviemaster.properties.RadarrProperties;
import com.erich.grosner.slackmoviemaster.properties.SlackBotProperties;
import com.erich.grosner.slackmoviemaster.properties.TMDBProperties;
import com.erich.grosner.slackmoviemaster.webservice.radarr.Movie;
import com.erich.grosner.slackmoviemaster.webservice.radarr.RadarrAPI;
import com.erich.grosner.slackmoviemaster.webservice.tmdb.TMDBApi;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import me.ramswaroop.jbot.core.slack.Bot;
import me.ramswaroop.jbot.core.slack.Controller;
import me.ramswaroop.jbot.core.slack.EventType;
import me.ramswaroop.jbot.core.slack.models.Event;
import me.ramswaroop.jbot.core.slack.models.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by egros on 6/7/2017.
 */
@Component
@RequiredArgsConstructor
public class SlackBot extends Bot {

    //these are all autowired in via the constructor and the RequiredArgsConstructor annotation
    private final SlackBotProperties slackBotProperties;
    private final RadarrProperties radarrProperties;
    private final RadarrAPI radarAPI;
    private final List<Response> responses;
    private final TMDBApi tmdbApi;
    private final TMDBProperties tmdbProperties;

    @Override
    public String getSlackToken() {
        return slackBotProperties.getToken();
    }

    @Override
    public Bot getSlackBot() {
        return this;
    }


    public void sendMessage() {

    }

    @Controller(events = {EventType.DIRECT_MENTION})
    public void onDirectMention(WebSocketSession session, Event event) throws URISyntaxException {
        String imdbId = "";
        String imdbUrl = "";
        String[] words = event.getText().split(" ");

        try {
            imdbId = Arrays.stream(words).filter(c -> c.startsWith("tt")).findFirst().orElse("");
            imdbUrl = Arrays.stream(words).filter(w -> w.startsWith("<http://www.imdb")).findFirst().orElse("");

            if(Strings.isNullOrEmpty(imdbId) && !Strings.isNullOrEmpty(imdbUrl)) {
                //parse out the id
                URI uri = new URI(imdbUrl.substring(1, imdbUrl.length() - 1));
                String[] paths = uri.getPath().split("/");
                imdbId = Arrays.stream(paths).filter(w -> w.startsWith("tt")).findFirst().orElse("");
            }
        } catch (Exception e) {
            reply(session, event, new Message(Response.randomResponse(responses)));
            return;
        }

        if (Strings.isNullOrEmpty(imdbId)) {
            //if we still haven't found an id, perhaps this is a title query?

            //does it start with the words in this list?
            List<String> searchingKeywords = Lists.newArrayList(
                    "search for",
                    "find me",
                    "find",
                    "search"
            );

            if(searchingKeywords.stream().anyMatch(s -> event.getText().startsWith(s))) {
                //take the rest of it and search for that movie
                //String removable = searchingKeywords.stream().filter(s -> event.getText().startsWith(s)).findFirst().get();

                //String titleResult = event.getText().replace(removable, "");

                reply(session, event, new Message(Response.randomResponse(responses)));
            }

            return;
        }

        List<Movie> results = radarAPI.searchByImdbId("imdb: "+ imdbId, radarrProperties.getKey());

        Movie firstResult = results.get(0);

        //update some props on this guy to 'add' him
        firstResult.setProfileId(7);
        firstResult.setQualityProfiles(7);
        firstResult.setMinimumAvailability("announced");
        firstResult.setMonitored(true);
        firstResult.getAddOptions().setSearchForMovie(true);

        //JsonNode result = radarAPI.addMovie(firstResult, radarrProperties.getKey());

        reply(session, event, new Message(String.format("Acquiring target: %s (%s).",
                firstResult.getTitle(),
                firstResult.getYear())));
    }
}

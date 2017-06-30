package com.erich.grosner.slackmoviemaster.web;

import com.erich.grosner.slackmoviemaster.properties.SlackBotProperties;
import com.erich.grosner.slackmoviemaster.properties.TMDBProperties;
import com.erich.grosner.slackmoviemaster.webservice.slack.SlackWebHook;
import com.erich.grosner.slackmoviemaster.webservice.tmdb.*;
import me.ramswaroop.jbot.core.slack.models.Attachment;
import me.ramswaroop.jbot.core.slack.models.RichMessage;
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

    @Autowired
    private SlackWebHook slackWebHook;

    @Autowired
    private SlackBotProperties slackBotProperties;

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
        if(sonarrRequest.getEventType() != SonarrEventType.DOWNLOAD && sonarrRequest.getEventType() != SonarrEventType.TEST) {
            //do nothing for now
            return "OK";
        }

        //find tmdb information
        TMDBFindResponse searchResults = tmdbApi.find(sonarrRequest.getSeries().getTvdbId() + "", ExternalSource.TVDB_ID, tmdbProperties.getKey());

        TMDBFindTvResult firstTvResult = searchResults.getTvResults().get(0);
        String tmdbTvId = firstTvResult.getId() + "";
        String seasonNumber = sonarrRequest.getEpisodes().get(0).getSeasonNumber() + "";
        String episodeNumber = sonarrRequest.getEpisodes().get(0).getEpisodeNumber() + "";

        TMDBSeasonEpisodeResponse episodeInfo = tmdbApi.getSeasonEpisode(tmdbTvId, seasonNumber, episodeNumber, tmdbProperties.getKey());

        //build slack message
        RichMessage message = new RichMessage(firstTvResult.getName() +
                " S" + seasonNumber +
                "E" + episodeNumber +
                " was added to plex");

        Attachment messageAttachment = new Attachment();
        messageAttachment.setTitle(episodeInfo.getName());
        messageAttachment.setColor("#36a64f");
        messageAttachment.setTitleLink("http://www.google.com");
        messageAttachment.setText(episodeInfo.getOverview());
        messageAttachment.setImageUrl("http://image.tmdb.org/t/p/w300" + episodeInfo.getStillPath());
        messageAttachment.setThumbUrl("http://image.tmdb.org/t/p/w92" + firstTvResult.getPosterPath());

        message.setAttachments(new Attachment[] { messageAttachment });

        slackWebHook.postRichMessage(message, slackBotProperties.getWebhookToken());

        return "OK";
    }

}

package com.erich.grosner.slackmoviemaster.web;

import com.erich.grosner.slackmoviemaster.properties.SlackBotProperties;
import com.erich.grosner.slackmoviemaster.webservice.slack.SlackWebHook;
import com.erich.grosner.slackmoviemaster.webservice.tvdb.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import lombok.extern.apachecommons.CommonsLog;
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
@CommonsLog
@RestController
public class WebController {

    @Autowired
    private TVDBApi tvdbApi;

    @Autowired
    private TVDBApiProperties tvdbApiProperties;

    @Autowired
    private SlackWebHook slackWebHook;

    @Autowired
    private SlackBotProperties slackBotProperties;

    @Autowired
    private ObjectMapper objectMapper;

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
    public String receiveFromSonarr(@RequestBody SonarrRequest sonarrRequest) throws JsonProcessingException {
        log.info("[REQ]: " + objectMapper.writeValueAsString(sonarrRequest));

        //what event type is it?
        if(sonarrRequest.getEventType() != SonarrEventType.DOWNLOAD) {
            //do nothing for now
            return "OK";
        }

        LoginResponse token = tvdbApi.login(LoginRequest.builder()
                .apikey(tvdbApiProperties.getKey())
                .userkey(tvdbApiProperties.getUserkey())
                .username(tvdbApiProperties.getUsername())
                .build());

        String tvdbId = sonarrRequest.getSeries().getTvdbId() + "";
        String seasonNumber = sonarrRequest.getEpisodes().get(0).getSeasonNumber() + "";
        String episodeNumber = sonarrRequest.getEpisodes().get(0).getEpisodeNumber() + "";

        SeriesResponse seriesResponse = tvdbApi.series(tvdbId, token.getToken());
        SeriesEpisodesResponse seriesEpisodesResponse = tvdbApi.queryBySeasonEpisode(tvdbId, ImmutableMap.of(
                SeriesEpisodeHeaders.AIRED_SEASON.getName(), seasonNumber,
                SeriesEpisodeHeaders.AIRED_EPISODE.getName(), episodeNumber
        ), token.getToken());

        BasicEpisode firstResult = seriesEpisodesResponse.getData().get(0);

        //get the full episode info
        EpisodeResponse episodeResponse = tvdbApi.queryByEpisodeId(firstResult.getId() + "", token.getToken());

        //build slack message
        RichMessage message = new RichMessage(seriesResponse.getData().getSeriesName() +
                " S" + seasonNumber +
                "E" + episodeNumber +
                " was added to plex");

        Attachment messageAttachment = new Attachment();
        messageAttachment.setTitle(firstResult.getEpisodeName());
        messageAttachment.setColor("#36a64f");
        messageAttachment.setTitleLink("http://www.google.com");
        messageAttachment.setText(firstResult.getOverview());
        messageAttachment.setImageUrl("https://www.thetvdb.com/banners/" + episodeResponse.getData().getFilename());
        messageAttachment.setThumbUrl("https://www.thetvdb.com/banners/" + seriesResponse.getData().getBanner());

        message.setAttachments(new Attachment[] { messageAttachment });

        slackWebHook.postRichMessage(message, slackBotProperties.getWebhookToken());

        return "OK";
    }

}

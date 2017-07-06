package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import com.google.common.collect.ImmutableMap;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by egros on 7/4/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TVDBApiTests {

    @Autowired
    private TVDBApi tvdbApi;

    @Autowired
    private TVDBApiProperties tvdbApiProperties;

    @Test
    @Ignore
    public void tvdbApi_login_shouldReturnToken() {
        LoginRequest loginReq = LoginRequest.builder()
                .apikey(tvdbApiProperties.getKey())
                .userkey(tvdbApiProperties.getUserkey())
                .username(tvdbApiProperties.getUsername()).build();

        LoginResponse loginResp = tvdbApi.login(loginReq);

        SeriesResponse series = tvdbApi.series("289574", loginResp.getToken());

        SeriesEpisodesResponse seriesEpisodesResponse = tvdbApi.queryBySeasonEpisode("289574",
                ImmutableMap.of("airedSeason", 2,
                                "airedEpisode", 176),
                loginResp.getToken());

        EpisodeResponse episodeResponse = tvdbApi.queryByEpisodeId(seriesEpisodesResponse.getData().get(0).getId() + "",
                loginResp.getToken());
    }
}

package com.erich.grosner.slackmoviemaster.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebControllerTests {

	String jsonRequest = "{\n" +
			"  \"episodes\":\n" +
			"  [\n" +
			"    {\n" +
			"      \"id\":6581,\n" +
			"      \"episodeNumber\":4,\n" +
			"      \"seasonNumber\":3,\n" +
			"      \"title\":\"Episode 4\",\n" +
			"      \"airDate\":\"2017-03-20\",\n" +
			"      \"airDateUtc\":\"2017-03-20T21:00:00Z\",\n" +
			"      \"quality\":\"Bluray-720p\",\n" +
			"      \"qualityVersion\":1,\n" +
			"      \"releaseGroup\":\"SHORTBREHD\"\n" +
			"    }\n" +
			"  ],\n" +
			"  \"release\":\n" +
			"  {\n" +
			"    \"quality\":\"Bluray-720p\",\n" +
			"    \"qualityVersion\":1,\n" +
			"    \"releaseGroup\":\"SHORTBREHD\",\n" +
			"    \"releaseTitle\":\"Broadchurch S03E04 720p BluRay x264-SHORTBREHD\",\n" +
			"    \"indexer\":\"IPTorrents\",\n" +
			"    \"size\":2340757248\n" +
			"  },\n" +
			"  \"eventType\":\"Grab\",\n" +
			"  \"series\":\n" +
			"  {\n" +
			"    \"id\":55,\n" +
			"    \"title\":\"Broadchurch\",\n" +
			"    \"path\":\"D:\\\\Downloads_V2\\\\TV\\\\Broadchurch\",\n" +
			"    \"tvdbId\":266398\n" +
			"  }\n" +
			"}";

	@Autowired
    private WebController webController;

	@Test
	public void receiveFromSonarr_shouldPostToSlackChannel() throws IOException {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, true);
        om.registerModule(new JavaTimeModule());

		SonarrRequest request = om.readValue(jsonRequest, SonarrRequest.class);


        webController.receiveFromSonarr(request);

	}

}

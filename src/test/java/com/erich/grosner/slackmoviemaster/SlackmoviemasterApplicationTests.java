package com.erich.grosner.slackmoviemaster;

import com.erich.grosner.slackmoviemaster.web.SonarrRequest;
import com.erich.grosner.slackmoviemaster.web.WebController;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SlackmoviemasterApplicationTests {

	String jsonRequest = "{\n" +
			"    \"EventType\": \"Download\",\n" +
			"    \"Series\": {\n" +
			"        \"Id\": 2,\n" +
			"        \"Title\": \"Preacher\",\n" +
			"        \"Path\": \"C:\\\\DownloadTest\\\\sonarr\\\\Preacher\",\n" +
			"        \"TvdbId\": 300472\n" +
			"    },\n" +
			"    \"Episodes\": [\n" +
			"        {\n" +
			"            \"Id\": 67,\n" +
			"            \"EpisodeNumber\": 1,\n" +
			"            \"SeasonNumber\": 2,\n" +
			"            \"Title\": \"The Stanchurian Candidate\",\n" +
			"            \"AirDate\": \"2015-08-24\",\n" +
			"            \"AirDateUtc\": \"2015-08-25T01:30:00Z\",\n" +
			"            \"Quality\": \"HDTV-720p\",\n" +
			"            \"QualityVersion\": 1,\n" +
			"            \"ReleaseGroup\": null,\n" +
			"            \"SceneName\": null\n" +
			"        }\n" +
			"    ]\n" +
			"}";

	@Autowired
    private WebController webController;

	@Test
	@Ignore
	public void contextLoads() throws IOException {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, true);
        om.registerModule(new JavaTimeModule());

		SonarrRequest request = om.readValue(jsonRequest, SonarrRequest.class);


        webController.receiveFromSonarr(request);

	}

}

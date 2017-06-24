package com.erich.grosner.slackmoviemaster.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by egros on 6/23/2017.
 */
@Data
public class SonarrRequest {
    @JsonProperty("EventType")
    private SonarrEventType eventType;
    @JsonProperty("Series")
    private SonarrSeries series;
    @JsonProperty("Episodes")
    private List<SonarrEpisode> episodes;
}
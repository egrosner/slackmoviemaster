package com.erich.grosner.slackmoviemaster.web;

import lombok.Data;

import java.util.List;

/**
 * Created by egros on 6/23/2017.
 */
@Data
public class SonarrRequest {
    private SonarrEventType eventType;
    private SonarrSeries series;
    private SonarrRelease release;
    private List<SonarrEpisode> episodes;
}
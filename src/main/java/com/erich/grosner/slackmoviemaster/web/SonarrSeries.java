package com.erich.grosner.slackmoviemaster.web;

import lombok.Data;

/**
 * Created by egros on 6/23/2017.
 */
@Data
public class SonarrSeries {
    private int id;
    private String title;
    private String path;
    private int tvdbId;
}
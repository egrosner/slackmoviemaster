package com.erich.grosner.slackmoviemaster.web;

import lombok.Data;

/**
 * Created by egros on 7/8/2017.
 */
@Data
public class SonarrRelease {
    private String quality;
    private int qualityVersion;
    private String releaseGroup;
    private String releaseTitle;
    private String indexer;
    private long size;
}
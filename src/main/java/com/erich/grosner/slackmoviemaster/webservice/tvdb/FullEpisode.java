package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import lombok.Data;

import java.util.List;

/**
 * Created by egros on 7/5/2017.
 */
@Data
public class FullEpisode {
    private int absoluteNumber;
    private int airedEpisodeNumber;
    private int airedSeason;
    private int airsAfterSeason;
    private int airsBeforeEpisode;
    private int airsBeforeSeason;
    private String director;
    private List<String> directors;
    private int dvdChapter;
    private String dvdDiscid;
    private int dvdEpisodeNumber;
    private int dvdSeason;
    private String episodeName;
    private String filename;
    private String firstAired;
    private List<String> guestStars;
    private int id;
    private String imdbId;
    private int lastUpdated;
    private String lastUpdatedBy;
    private String overview;
    private String productionCode;
    private String seriesId;
    private String showUrl;
    private int siteRating;
    private int siteRatingCount;
    private String thumbAdded;
    private int thumbAuthor;
    private String thumbHeight;
    private String thumbWidth;
    private List<String> writers;
}

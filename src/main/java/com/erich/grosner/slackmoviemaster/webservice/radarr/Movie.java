package com.erich.grosner.slackmoviemaster.webservice.radarr;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.List;

/**
 * Created by egros on 6/7/2017.
 */
@Data
public class Movie {
    private String title;
    private String sortTitle;
    private int sizeOnDisk;
    private String status;
    private String overview;
    private String inCinemas;
    private List<MovieImage> images;
    private boolean downloaded;
    private String remotePoster;
    private int year;
    private boolean hasFile;
    private int profileId;
    private String pathState;
    private boolean monitored;
    private String minimumAvailability;
    private boolean isAvailable;
    private String folderName;
    private int runtime;
    private int tmdbId;
    private String titleSlug;
    private List<Object> genres;
    private List<Object> tags;
    private String added;
    private Object ratings;
    private List<Object> alternativeTitles;
    private int qualityProfiles;

    //things for the post
    private int episodeFileCount = 0;
    private int episodeCount = 0;
    private boolean isExisting = false;
    private boolean saved = false;
    private boolean deleted = false;
    private String rootFolderPath = "D:\\Downloads_V2\\Movies\\";
    private MovieAddOptions addOptions = new MovieAddOptions();
}

/*

{"title":"Batman",
"sortTitle":"batman",
"sizeOnDisk":0,
"status":"released",
"overview":"The Dark Knight of Gotham City begins his war on crime with his
    first major enemy being the clownishly homicidal Joker, who has seized
    control of Gotham's underworld.",
"inCinemas":"1989-06-23T00:00:00Z",
"images":
    [
        {"coverType":"poster",
            "url":"http://image.tmdb.org/t/p/original/kBf3g9crrADGMc2AMAMlLBgSm2h.jpg"}
    ],
"downloaded":false,
"remotePoster":"http://image.tmdb.org/t/p/original/kBf3g9crrADGMc2AMAMlLBgSm2h.jpg",
"year":1989,
"hasFile":false,
"profileId":"7",
"pathState":"dynamic",
"monitored":true,
"minimumAvailability":"announced",
"isAvailable":true,
"folderName":"",
"runtime":0,
"tmdbId":268,
"titleSlug":"batman-268",
"genres":[],
"tags":[],
"added":"0001-01-01T00:00:00Z",
"ratings":
    {"votes":1759,
    "value":7},
"alternativeTitles":[],
"qualityProfileId":0,
"episodeFileCount":0,
"episodeCount":0,
"isExisting":false,
"saved":false,
"deleted":false,
"rootFolderPath":"D:\\Downloads_V2\\Movies\\",
"addOptions":
    {"ignoreEpisodesWithFiles":false,
    "ignoreEpisodesWithoutFiles":false,
    "searchForMovie":false}
}
 */
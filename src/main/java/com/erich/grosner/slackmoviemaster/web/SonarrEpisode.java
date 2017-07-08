package com.erich.grosner.slackmoviemaster.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by egros on 6/23/2017.
 */
@Data
public class SonarrEpisode {
    private int id;
    private int episodeNumber;
    private int seasonNumber;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "EST")
    private LocalDate airDate;
    private LocalDateTime airDateUtc;
    private String quality;
    private int qualityVersion;
    private String releaseGroup;
    private String sceneName;
}

package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by egros on 7/4/2017.
 */
@Data
public class TVDBErrors {
    @JsonProperty("invalidFilters")
    private List<String> invalidFilters;
    @JsonProperty("invalidLanguage")
    private String invalidLanguage;
    @JsonProperty("invalidQueryParams")
    private List<String> invalidQueryParams;
}

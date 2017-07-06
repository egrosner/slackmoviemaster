package com.erich.grosner.slackmoviemaster.webservice.tvdb;

import lombok.Builder;
import lombok.Data;

/**
 * Created by egros on 7/1/2017.
 */
@Data
@Builder
public class LoginRequest {
    private String username;
    private String apikey;
    private String userkey;
}

package com.erich.grosner.slackmoviemaster.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by egros on 6/8/2017.
 */
@RestController("/start")
public class WebController {
    @GetMapping
    public String start() {
        return "booting up...";
    }

    //intercept from radarr / sonarr
    @PostMapping
    public String receive(@RequestBody String json) {

        System.out.println(json.toString());

        return "OK";
    }
}

package com.erich.grosner.slackmoviemaster.model;

import lombok.Data;

import java.util.List;
import java.util.Random;

/**
 * Created by egros on 6/8/2017.
 */
@Data
public class Response {
    private String message;

    public static String randomResponse(List<Response> responses) {
        Random random = new Random();

        return responses.get(random.nextInt(responses.size())).getMessage();
    }
}

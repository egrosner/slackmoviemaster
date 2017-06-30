package com.erich.grosner.slackmoviemaster.webservice.slack;

import feign.Param;
import feign.RequestLine;
import feign.Response;
import me.ramswaroop.jbot.core.slack.models.RichMessage;

/**
 * Created by egros on 6/28/2017.
 */
public interface SlackWebHook {
    @RequestLine("POST /services/{token}")
    Response postRichMessage(RichMessage message, @Param("token") String token);
}

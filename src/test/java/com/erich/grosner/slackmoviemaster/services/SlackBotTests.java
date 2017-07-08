package com.erich.grosner.slackmoviemaster.services;

import me.ramswaroop.jbot.core.slack.models.Event;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by egros on 7/8/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SlackBotTests {

    @Autowired
    private SlackBot slackBot;

    @Test
    @Ignore
    public void test() {
        Event event = new Event();
        event.setText("");

        //slackBot.onDirectMention(null, );
    }

}

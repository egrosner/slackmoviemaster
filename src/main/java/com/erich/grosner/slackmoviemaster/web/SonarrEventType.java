package com.erich.grosner.slackmoviemaster.web;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by egros on 6/23/2017.
 */
@RequiredArgsConstructor
public enum SonarrEventType {
    GRAB("Grab"),
    DOWNLOAD("Download"),
    UPGRADE("Upgrade"),
    TEST("Test");

    @Getter(onMethod = @__(@JsonValue))
    private final String name;
}

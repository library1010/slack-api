package com.hos.slack.ui.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SlackDataSource {
    STATIC("static"),
    USERS("users"),
    CHANNELS("channels"),
    CONVERSATIONS("conversations"),
    EXTERNAL("external"),
    ;
    
    private String represent;
}

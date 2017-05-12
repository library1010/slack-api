package com.hos.slack.core;

import lombok.Data;

@Data
public class SlackInformation {
    private String token;
    private String channel;
    private String url;
}

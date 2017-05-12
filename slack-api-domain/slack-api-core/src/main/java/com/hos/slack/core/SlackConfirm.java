package com.hos.slack.core;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SlackConfirm {
    private String title;
    private String text;
    private String okText;
    private String dismissText;
}

package com.hos.slack.ui.button;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SlackButtonStyle {
    DEFAULT("default"),
    PRIMARY("primary"),
    DANGER("danger"),
    ;
    
    private String represent;
}

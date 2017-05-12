package com.hos.slack.core;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SlackField {
    
    private String title;
    private String value;
    @SerializedName("short") private boolean isShort;
    
}

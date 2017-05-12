package com.hos.slack.core;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Builder
@Getter
public class SlackMessages {

    private String username;
    private String iconEmoji;
    private String channel;
    private String text;
    private int linkNames;
    @SerializedName("mrkdwn") private boolean markDown;
    @Singular("addAttachment") private List<SlackAttachment> attachments;
    private String responseType;

}

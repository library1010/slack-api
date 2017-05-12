package com.hos.slack.core;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

@Getter
@Builder
public class SlackAttachment {

    private String text;
    private String fallback;
    private String color;
    private String pretext;
    private String authorName;
    private String authorLink;
    @Singular("addField") private List<SlackField> fields;
    @Singular("addMarkDownIn") @SerializedName("mrkdwn_in") private List<String> markDownIn;
    private String footer;
    private String footerIcon;
    @SerializedName("ts") private long timeStamp;
    private String imageUrl;
    private String callbackId;
    private String attachmentType;
    @Singular("addAction") private List<SlackAction> actions;

}

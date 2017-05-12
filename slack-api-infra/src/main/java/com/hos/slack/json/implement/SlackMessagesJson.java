package com.hos.slack.json.implement;

import com.hos.slack.core.SlackMessages;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
public class SlackMessagesJson extends MessageJson {

    private SlackMessages slackMessage;

    @Override
    public String getStringEntity() {
        return getJsonCreator().toJson(slackMessage);
    }
}

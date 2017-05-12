package com.hos.slack.json.implement;

import com.hos.slack.core.token.SlackToken;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class TokenJson extends MessageJson {

    private SlackToken slackToken;

    @Override
    public String getStringEntity() {
//        return getJsonCreator().toJson(slackToken);
        return "token=" + slackToken.getToken();
    }

}

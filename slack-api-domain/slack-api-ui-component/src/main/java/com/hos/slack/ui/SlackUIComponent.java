package com.hos.slack.ui;

import com.hos.slack.core.SlackAction;
import com.hos.slack.core.SlackAction.SlackActionBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class SlackUIComponent {
    
    private String name;
    private String text;

    public SlackAction toSlackAction() {
        return buildAction().build();
    }
    
    protected SlackActionBuilder buildAction() {
        return SlackAction.builder().name(name).text(text).type(getType());
    }
    protected abstract String getType();
}

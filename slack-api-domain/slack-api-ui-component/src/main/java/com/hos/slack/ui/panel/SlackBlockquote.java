package com.hos.slack.ui.panel;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hos.slack.core.SlackAttachment;
import com.hos.slack.ui.SlackUIComponent;
import com.hos.slack.ui.SlackUIObject;

public class SlackBlockquote implements SlackUIObject<SlackAttachment> {

    private List<SlackUIComponent> uiComponents;
    private String text;

    public SlackBlockquote(String text) {
        this.text = text;
    }

    @Override
    public SlackAttachment toSlackObject() {
        return SlackAttachment
            .builder()
            .text(text)
            .actions(Optional.ofNullable(uiComponents).orElse(new ArrayList<>()).stream().map(e -> e.toSlackObject()).collect(toList()))
            .build();
    }

    public SlackBlockquote add(SlackUIComponent component) {
        if (uiComponents == null) {
            uiComponents = new ArrayList<>();
        }
        uiComponents.add(component);
        return this;
    }

}

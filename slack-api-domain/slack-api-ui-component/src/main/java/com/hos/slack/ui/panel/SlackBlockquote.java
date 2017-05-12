package com.hos.slack.ui.panel;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hos.slack.core.SlackAttachment;
import com.hos.slack.ui.SlackUIComponent;

public class SlackBlockquote {

    private List<SlackUIComponent> uiComponents;
    private String text;

    public SlackBlockquote(String text) {
        this.text = text;
    }

    public SlackAttachment toAttachment() {
        return SlackAttachment
            .builder()
            .text(text)
            .actions(Optional.ofNullable(uiComponents).orElse(new ArrayList<>()).stream().map(e -> e.toSlackAction()).collect(toList()))
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

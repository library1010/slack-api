package com.hos.slack.ui.panel;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hos.slack.core.SlackMessages;
import com.hos.slack.ui.SlackUIObject;

public class SlackMessagePanel implements SlackUIObject<SlackMessages> {

    private List<SlackBlockquote> blockquotes;
    private String text;

    public SlackMessagePanel(String text) {
        this.text = text;
    }

    public SlackMessagePanel add(SlackBlockquote blockquote) {
        if (blockquotes == null) {
            blockquotes = new ArrayList<>();
        }
        blockquotes.add(blockquote);
        return this;
    }

    @Override
    public SlackMessages toSlackObject() {
        return SlackMessages
            .builder()
            .text(text)
            .attachments(Optional.ofNullable(blockquotes).orElse(new ArrayList<>()).stream().map(e -> e.toSlackObject()).collect(toList()))
            .build();
    }

}

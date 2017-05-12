package com.hos.slack.ui.button;

import com.hos.slack.core.SlackConfirm;

import lombok.Value;

@Value
public class SlackConfirmPopUp {

    String title;
    String text;
    String okText;
    String dismissText;

    public SlackConfirm toConfirm() {
        return SlackConfirm.builder().title(title).text(text).okText(okText).dismissText(dismissText).build();
    }
}

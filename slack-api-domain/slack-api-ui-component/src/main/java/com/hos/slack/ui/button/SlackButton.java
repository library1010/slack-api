package com.hos.slack.ui.button;

import com.hos.slack.core.SlackAction.SlackActionBuilder;
import com.hos.slack.core.SlackConfirm;
import com.hos.slack.ui.SlackUIComponent;

public class SlackButton extends SlackUIComponent {

    private String value;
    protected SlackConfirm slackConfirmation;

    public SlackButton(String name, String buttonText, String value) {
        super(name, buttonText);
        this.value = value;
    }

    @Override
    protected SlackActionBuilder buildAction() {
        return super.buildAction().value(value).confirm(slackConfirmation);
    }

    public SlackButton addConfirmMessage(String title, String text, String okText, String dismissText) {
        this.slackConfirmation = SlackConfirm.builder().title(title).text(text).okText(okText).dismissText(dismissText).build();
        return this;
    }

    @Override
    protected String getType() {
        return "button";
    }

}

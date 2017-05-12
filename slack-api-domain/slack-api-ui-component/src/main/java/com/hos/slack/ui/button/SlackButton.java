package com.hos.slack.ui.button;

import com.hos.slack.core.SlackAction.SlackActionBuilder;
import com.hos.slack.ui.SlackUIComponent;

public class SlackButton extends SlackUIComponent {

    private String value;
    private SlackConfirmPopUp popup;

    public SlackButton(String name, String buttonText, String value) {
        super(name, buttonText);
        this.value = value;
    }

    @Override
    protected SlackActionBuilder buildAction() {
        return super.buildAction().value(value).confirm(popup == null ? null : popup.toConfirm());
    }

    public SlackButton addConfirmPopup(SlackConfirmPopUp popup) {
        this.popup = popup;
        return this;
    }

    @Override
    protected String getType() {
        return "button";
    }

}

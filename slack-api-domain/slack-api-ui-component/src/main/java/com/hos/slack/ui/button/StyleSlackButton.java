package com.hos.slack.ui.button;

import com.hos.slack.core.SlackAction.SlackActionBuilder;

public class StyleSlackButton extends SlackButton {

    private SlackButtonStyle style;
    
    public StyleSlackButton(String name, String buttonText, String value, SlackButtonStyle style) {
        super(name, buttonText, value);
        this.style = style;
    }
    
    @Override
    protected SlackActionBuilder buildAction() {
        return super.buildAction().style(style.getRepresent());
    }
}

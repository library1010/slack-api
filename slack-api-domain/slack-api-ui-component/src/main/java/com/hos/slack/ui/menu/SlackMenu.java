package com.hos.slack.ui.menu;

import com.hos.slack.ui.SlackUIComponent;

public abstract class SlackMenu extends SlackUIComponent {

    public SlackMenu(String name, String text) {
        super(name, text);
    }

    @Override
    protected String getType() {
        return "select";
    }
}

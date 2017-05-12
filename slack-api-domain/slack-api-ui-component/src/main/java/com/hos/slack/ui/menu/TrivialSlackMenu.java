package com.hos.slack.ui.menu;

import java.util.ArrayList;
import java.util.List;

import com.hos.slack.core.SlackAction.SlackActionBuilder;
import com.hos.slack.core.SlackOption;

public class TrivialSlackMenu extends SlackMenu {

    private List<SlackOption> options;

    public TrivialSlackMenu(String name, String text) {
        super(name, text);
    }

    @Override
    protected SlackActionBuilder buildAction() {
        return super.buildAction().options(options);
    }

    public void addOption(String text, String value) {
        if (options == null) {
            options = new ArrayList<>();
        }
        options.add(new SlackOption(text, value));
    }
}

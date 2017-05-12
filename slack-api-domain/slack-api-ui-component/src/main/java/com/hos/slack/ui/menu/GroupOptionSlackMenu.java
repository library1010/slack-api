package com.hos.slack.ui.menu;

import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.hos.slack.core.SlackAction.SlackActionBuilder;
import com.hos.slack.core.SlackGroupOption;
import com.hos.slack.core.SlackGroupOption.SlackGroupOptionBuilder;
import com.hos.slack.core.SlackOption;

public class GroupOptionSlackMenu extends SlackMenu {

    private Map<String, SlackGroupOptionBuilder> optionGroups;

    public GroupOptionSlackMenu(String name, String text) {
        super(name, text);
    }

    public void addOptionGroup(String groupText, String optionText, String optionValue) {
        if (optionGroups == null) {
            optionGroups = new HashMap<>();
        }
        SlackOption slackOption = new SlackOption(optionText, optionValue);
        if (optionGroups.containsKey(groupText)) {
            optionGroups.get(groupText).addOption(slackOption);
            return;
        }
        optionGroups.put(groupText, SlackGroupOption.builder().text(groupText).addOption(slackOption));
    }

    @Override
    protected SlackActionBuilder buildAction() {
        return super.buildAction().optionGroups(
            Optional.ofNullable(optionGroups).orElse(new HashMap<>()).values().stream().map(e -> e.build()).collect(toList()));
    }

}

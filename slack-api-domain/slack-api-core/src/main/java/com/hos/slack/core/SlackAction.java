package com.hos.slack.core;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Builder
@Value
public class SlackAction {

    private String name;
    private String text;
    private String type;
    private String value;
    private String style;
    private SlackConfirm confirm;
    @Singular("addOption") private List<SlackOption> options;
    @Singular("addGroupOption") private List<SlackGroupOption> optionGroups;
    private String dataSource;
}

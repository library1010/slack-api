package com.hos.slack.core;

import java.util.List;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Builder
@Value
public class SlackGroupOption {

    String text;
    @Singular("addOption") List<SlackOption> options;
}

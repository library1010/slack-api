package com.hos.slack.ui.menu;

import com.hos.slack.core.SlackAction.SlackActionBuilder;

public class DatasourceSlackMenu extends SlackMenu {

    private SlackDataSource dataSource;
    
    public DatasourceSlackMenu(String name, String text, SlackDataSource dataSource) {
        super(name, text);
        this.dataSource = dataSource;
    }
    
    @Override
    protected SlackActionBuilder buildAction() {
        return super.buildAction().dataSource(dataSource.getRepresent());
    }
}

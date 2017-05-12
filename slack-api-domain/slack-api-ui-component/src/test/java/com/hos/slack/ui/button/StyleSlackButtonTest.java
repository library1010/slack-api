package com.hos.slack.ui.button;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hos.slack.core.SlackAction;
import com.hos.slack.core.SlackConfirm;

import mockit.Injectable;
import mockit.Mocked;
import mockit.StrictExpectations;
import mockit.Tested;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class StyleSlackButtonTest {

    @Tested StyleSlackButton slackButton;
    @Injectable String name;
    @Injectable String buttonText;
    @Injectable String value;
    @Injectable SlackButtonStyle style;
    
    @Test
    public void testToSlackAction() throws Exception {
        assertThat(
            new StyleSlackButton("game", "Chess", "chess", SlackButtonStyle.DANGER).toSlackObject().toString(),
            is(SlackAction.builder().name("game").text("Chess").type("button").style("danger").value("chess").confirm(null).build().toString()));
    }
    
    @Test
    public void testBuilder(@Mocked SlackAction unusedSlackAction,
            @Mocked SlackAction.SlackActionBuilder slackActionBuilder) throws Exception {
        new StrictExpectations() {{
            SlackAction.builder(); result = slackActionBuilder;
            slackActionBuilder.name(name); result = slackActionBuilder;
            slackActionBuilder.text(buttonText); result = slackActionBuilder;
            slackActionBuilder.type("button"); result = slackActionBuilder;
            slackActionBuilder.value(value); result = slackActionBuilder;
            slackActionBuilder.confirm((SlackConfirm) any); result = slackActionBuilder;
            slackActionBuilder.style(style.getRepresent()); result = slackActionBuilder;
        }};
        slackButton.buildAction();
    }
}

package com.hos.slack.sample;

import com.hos.slack.infra.SlackIncomingWebhook;
import com.hos.slack.json.implement.SlackMessagesJson;
import com.hos.slack.ui.button.SlackButton;
import com.hos.slack.ui.button.SlackButtonStyle;
import com.hos.slack.ui.button.SlackConfirmPopUp;
import com.hos.slack.ui.button.StyleSlackButton;
import com.hos.slack.ui.panel.SlackBlockquote;
import com.hos.slack.ui.panel.SlackMessagePanel;

public class Sample {

    public static void main(String[] args) {
        SlackMessagePanel panel =
            new SlackMessagePanel("Would you like to play a game?").add(
                new SlackBlockquote("Choose a game to play")
                    .add(new StyleSlackButton("game", "Chess", "chess", SlackButtonStyle.PRIMARY))
                    .add(new SlackButton("game", "Falken's Maze", "maze"))
                    .add(
                        new StyleSlackButton("game", "Thermonuclear War", "war", SlackButtonStyle.DANGER).addConfirmPopup(
                            new SlackConfirmPopUp("Are you sure?", "Wouldn't you prefer a good game of chess?", "Yes", "No"))));

        new SlackIncomingWebhook("incoming webhook url").send(new SlackMessagesJson(panel.toSlackObject()));
    }
}

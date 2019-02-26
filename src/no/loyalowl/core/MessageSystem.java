package no.loyalowl.core;

import no.loyalowl.game.Game;

import java.util.ArrayList;
import java.util.List;

public class MessageSystem
{
    private int x, y;
    private List<String> messages;
    private int maxMessages;

    /**
     * @param x X position of bottom left corner
     * @param y Y position of bottom left corner
     * @param maxMessages Number of messages the box will display
     * */
    public MessageSystem(int x, int y, int maxMessages)
    {
        this.x = x;
        this.y = y;
        this.maxMessages = maxMessages;

        messages = new ArrayList<>();
    }

    public void draw()
    {
        Game.stateManager.currentState.writeLine("────────────────────────────────────────────────────────────────────────────────", x, y - maxMessages);
        int index = messages.size();
        for (int i = 0; i < messages.size(); i++)
        {
            Game.stateManager.currentState.writeLine("> " + messages.get(i), 0, y - (index - 1));
            index--;
        }
    }

    public void addMessage(String message)
    {
        //TODO: Add some sort of history. In case you get more than max messages at once

        // Check if the max messages has been reached
        if (messages.size() == maxMessages)
        {
            // Remove the first message
            messages.remove(0);
        }

        // Add new message
        messages.add(message);
    }
}

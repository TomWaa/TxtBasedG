package no.loyalowl.game.states;

import no.loyalowl.core.ConsoleColors;
import no.loyalowl.core.State;
import no.loyalowl.game.Game;

public class Buy extends State
{
    public Buy(int width, int height, String key) {
        super(width, height, key);
    }

    @Override
    public void update()
    {
        switch (Game.input.inputString)
        {
            case "1":
                Game.messageSystem.addMessage("Tried to open menu 1, but I don't feel like it");
                break;
            case "2":
                Game.messageSystem.addMessage("Tried to open menu 2, but I don't feel like it");
                break;
            case "back":
                Game.stateManager.changeState("MainMenu");
                break;
            case "quit":
                System.exit(0);
                break;
            default:
                Game.messageSystem.addMessage("Unknown command. Please try again");
                break;
        }
    }

    @Override
    public void draw()
    {
        State currentState = Game.stateManager.currentState;

        currentState.writeLine("Buy",                   0, 0, ConsoleColors.GREEN_BOLD);
        currentState.writeLine("1. Auto clicker",       1, 1);
        currentState.writeLine("2. Tower",              1, 2);



        drawScreen();
    }
}

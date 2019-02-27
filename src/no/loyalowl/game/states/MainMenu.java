package no.loyalowl.game.states;

import no.loyalowl.core.ConsoleColors;
import no.loyalowl.game.Game;
import no.loyalowl.core.State;

import java.util.Random;

public class MainMenu extends State
{
    private Random rand = new Random();

    public MainMenu(int width, int height, String key)
    {
        super(width, height, key);
    }

    @Override
    public void update()
    {
        switch (Game.input.inputString)
        {
            case "1":
                Game.stateManager.changeState("Buy");
                break;
            case "2":
                Game.messageSystem.addMessage("Tried to open menu 2, but I don't feel like it");
                break;
            case "3":
                Game.messageSystem.addMessage("Tried to open menu 3, but I don't feel like it");
                break;
            case "4":
                Game.messageSystem.addMessage("Random message " + rand.nextInt());
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

        currentState.writeLine("Main menu",           0, 0, ConsoleColors.GREEN_BOLD);
        currentState.writeLine("1. Buy",              1, 1);
        currentState.writeLine("2. Upgrade",          1, 2);
        currentState.writeLine("3. Skills",           1, 3);
        currentState.writeLine("4. Add a message",    1, 4);

        currentState.writeLineVertical("||||||||||||||||||┴", 35, 0);

        currentState.writeLine("Welcome", 42, 0);

        drawScreen();
    }
}

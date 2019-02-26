package no.loyalowl.game;

import no.loyalowl.core.Engine;
import no.loyalowl.core.MessageSystem;
import no.loyalowl.core.StateManager;
import no.loyalowl.game.states.MainMenu;

public class Game extends Engine
{
    public static MessageSystem messageSystem;
    public static StateManager stateManager;

    public Game()
    {
        super();
    }

    @Override
    public void init()
    {
        super.init();

        stateManager = new StateManager();
        stateManager.add(new MainMenu(80, 23));

        messageSystem = new MessageSystem(0, stateManager.currentState.getHeight() - 2, 3);
    }

    @Override
    public void update()
    {
        super.update();
        stateManager.currentState.update();
    }

    @Override
    public void draw()
    {
        messageSystem.draw();
        stateManager.currentState.draw();
    }
}

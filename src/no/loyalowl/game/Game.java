package no.loyalowl.game;

import no.loyalowl.core.Engine;
import no.loyalowl.game.states.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class Game extends Engine
{
    public MenuState currentMenu;
    public List<MenuState> menuStates;

    public Game()
    {
        super();
    }

    @Override
    public void init()
    {
        super.init();

        menuStates = new ArrayList<>();
        menuStates.add(new MainMenu(80, 23));

        currentMenu = menuStates.get(0);
    }

    @Override
    public void update()
    {
        super.update();

        switch (input.inputString)
        {
            case "1":
                currentMenu.writeLine("> Tried to open menu 1, but I don't feel like it", 0, currentMenu.getHeight() - 2);
                break;
            case "2":
                currentMenu.writeLine("> Tried to open menu 2, but I don't feel like it", 0, currentMenu.getHeight() - 2);
                break;
            case "3":
                currentMenu.writeLine("> Tried to open menu 3, but I don't feel like it", 0, currentMenu.getHeight() - 2);
                break;
            case "quit":
                System.exit(0);
                break;
            default:
                currentMenu.writeLine("> Unknown command. Please try again", 0, currentMenu.getHeight() - 2);
                break;
        }
    }

    @Override
    public void draw()
    {
        //clearTerminal();
        //System.out.println("--------------------------------------------------------------------------------");
        currentMenu.writeLine("/------------------------------------------------------------------------------\\", 0, 0);

        currentMenu.writeLine("1. Buy", 0, 2);
        currentMenu.writeLine("2. Upgrade", 0, 3);
        currentMenu.writeLine("3. Skills", 0, 4);

        currentMenu.writeLine("================================================================================", 0, currentMenu.getHeight() - 1);
        currentMenu.drawScreen();
    }
}

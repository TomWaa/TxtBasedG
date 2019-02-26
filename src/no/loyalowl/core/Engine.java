package no.loyalowl.core;

import java.util.Date;

public class Engine
{
    public static Input input = Input.getInstance();

    private boolean running = true;

    public Engine()
    {
        init();
        draw();
        runLoop();
    }

    public void init()
    {

    }

    public void update()
    {
        input.updateInput();
    }

    public void draw()
    {
    }

    public void clearTerminal()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void runLoop()
    {
        while(running)
        {
            update();
            draw();
        }
    }
}

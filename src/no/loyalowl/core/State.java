package no.loyalowl.core;

import java.io.Console;

public class State
{
    public String stateKey;

    private int width;
    private int height;

    private Cell[] screenBuffer;
    private int x;
    private int y;
    private String foregroundColor;

    public State(int width, int height, String key)
    {
        this.width = width;
        this.height = height;
        stateKey = key;

        screenBuffer = new Cell[height * width];
        for (int i = 0; i < screenBuffer.length; i++)
        {
            screenBuffer[i] = new Cell(' ');
        }
        clearBuffer();
    }

    public void update() {}
    public void draw() {}

    /* Getters and setters */
    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    /* Methods */
    public void writeLine(String text, int x, int y, String style)
    {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++)
        {
            Cell currentCell = screenBuffer[y * width + (x + i)];

            currentCell.setStyle(style);
            currentCell.character = textArray[i];
        }
    }

    public void writeLine(String text, int x, int y)
    {
        writeLine(text, x, y, ConsoleColors.DEFAULT);
    }

    public void writeLineVertical(String text, int x, int y, String style)
    {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++)
        {
            Cell currentCell = screenBuffer[(y + i) * width + x];

            currentCell.setStyle(style);
            currentCell.character = textArray[i];
        }
    }

    public void writeLineVertical(String text, int x, int y)
    {
        writeLineVertical(text, x, y, ConsoleColors.DEFAULT);
    }

    public void styleLine(int x, int y, int length, String style)
    {
        for (int i = 0; i < length; i++)
        {
            screenBuffer[y * width + (x + i)].setStyle(style);
        }
    }

    public void drawScreen()
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                System.out.print(
                        screenBuffer[y * width + x].getStyle() +
                        screenBuffer[y * width + x].character +
                        ConsoleColors.RESET);
            }

            System.out.print("\n");
        }

        clearBuffer();
    }

    private void clearBuffer()
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                screenBuffer[y * width + x].character = ' ';
            }
        }
    }
}

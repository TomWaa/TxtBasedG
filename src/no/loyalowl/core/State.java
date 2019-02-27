package no.loyalowl.game;

public class State
{
    public String stateKey;

    private int width;
    private int height;

    private char[] screenBuffer;

    public State(int width, int height, String key)
    {
        this.width = width;
        this.height = height;
        stateKey = key;

        screenBuffer = new char[height * width];
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
    public void writeLine(String text, int x, int y)
    {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++)
        {
            screenBuffer[y * width + (x + i)] = textArray[i];
        }
    }

    public void writeLineVertical(String text, int x, int y)
    {
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++)
        {
            screenBuffer[(y + i) * width + x] = textArray[i];
        }
    }

    public void drawScreen()
    {
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                System.out.print(screenBuffer[y * width + x]);
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
                screenBuffer[y * width + x] = ' ';
            }
        }
    }
}

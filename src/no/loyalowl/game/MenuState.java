package no.loyalowl.game;

public class MenuState
{
    private int width;
    private int height;

    private char[] screenBuffer;

    public MenuState(int width, int height)
    {
        this.width = width;
        this.height = height;

        screenBuffer = new char[height * width];
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                screenBuffer[y * width + x] = '.';
            }
        }

        writeLine("Thomas", 0, 0);
        writeLineVertical("|||||", width - 1, 0);
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

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
    }
}

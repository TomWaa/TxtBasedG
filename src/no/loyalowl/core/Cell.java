package no.loyalowl.core;

import java.awt.*;

public class Cell
{
    public char character;

    private String style;

    public Cell(char character)
    {
        this.character = character;
        style = ConsoleColors.DEFAULT;
    }

    public String getStyle()
    {
        return style;
    }

    public void setStyle(String style)
    {
        this.style = style;
    }
}

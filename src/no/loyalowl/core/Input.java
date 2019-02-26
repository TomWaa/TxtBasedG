package no.loyalowl.core;

import java.util.Scanner;

public class Input
{
    public String inputString;

    private Scanner scanner;

    private static Input instance;
    private Input()
    {
        scanner = new Scanner(System.in);
    }

    public static Input getInstance()
    {
        if (instance == null)
        {
            instance = new Input();
        }
        return instance;
    }

    public void updateInput()
    {
        inputString = scanner.nextLine();
    }
}

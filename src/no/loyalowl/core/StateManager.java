package no.loyalowl.core;

import no.loyalowl.game.Game;

import java.util.ArrayList;
import java.util.List;

public class StateManager
{
    public State currentState;
    private List<State> states;

    public StateManager()
    {
        states = new ArrayList<>();
    }

    public void add(State state)
    {
        // Check if there is a state with the same key
        for (int i = 0; i < states.size(); i++)
        {
            if (state.stateKey == states.get(i).stateKey)
            {
                break;
            }
        }

        states.add(state);
        if (states.size() == 1) { currentState = state; }
    }

    public void changeState(String stateKey)
    {
        for (int i = 0; i < states.size(); i++)
        {
            if (stateKey == states.get(i).stateKey)
            {
                currentState = states.get(i);
                break;
            }
        }

        System.out.println("Didn't find the state " + stateKey);
    }
}

package no.loyalowl.core;

import no.loyalowl.game.State;

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
        states.add(state);
        if (states.size() == 1) { currentState = state; }
    }

    public void changeState(State state)
    {

    }
}

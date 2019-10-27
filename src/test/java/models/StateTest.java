package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import types.StateValue;

public class StateTest {

    @Test
    public void givenInitialStateWhenChangeNextThenGoToInGameState() {
      final State state= new State();
      state.next();
      assertEquals(StateValue.OPENED_GAME, state.getStateValue());
    }

    @Test
    public void givenInGameStateWhenChangeNextThenGoToFinishState() {
        final State state= new State();
        state.next();
        state.next();
        assertEquals(StateValue.FINAL, state.getStateValue());
    }

    @Test
    public void givenFinishStateWhenChangeNextThenGoToExitState() {
        final State state= new State();
        state.next();
        state.next();
        state.next();
        assertEquals(StateValue.EXIT, state.getStateValue());
    }

    @Test
    public void givenStateWhenResetThenReturnToInitialState()
    {
        final State state= new State();
        state.next();
        state.next();
        state.reset();
        assertEquals(StateValue.INITIAL, state.getStateValue());
    }
}
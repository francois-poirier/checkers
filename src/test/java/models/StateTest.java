package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StateTest {

    @Test
    public void givenInitialStateWhenChangeNextThenGoToInGameState() {
      final State state= new State(StateValue.INITIAL);
      state.next();
      assertEquals(StateValue.OPEN_GAME, state.getStateValue());
    }

    @Test
    public void givenInGameStateWhenChangeNextThenGoToFinishState() {
        final State state= new State(StateValue.OPEN_GAME);
        state.next();
        assertEquals(StateValue.FINISH, state.getStateValue());
    }

    @Test
    public void givenFinishStateWhenChangeNextThenGoToExitState() {
        final State state= new State(StateValue.FINISH);
        state.next();
        assertEquals(StateValue.EXIT, state.getStateValue());
    }

    @Test
    public void givenStateWhenResetThenReturnToInitialState()
    {
        final State state= new State(StateValue.OPEN_GAME);
        state.reset();
        assertEquals(StateValue.INITIAL, state.getStateValue());
    }
}
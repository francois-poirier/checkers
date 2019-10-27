package controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import models.Game;
import models.State;
import types.StateValue;

public class CancelControllerTest {


    @Test
    public void givenOpenedGameStateWhenCancelThenFinishGame() {
        final Game game = new Game();
        final State state = new State();
        state.next();
        CancelController sut = new CancelController(game,state);
        sut.cancel();
        assertNotNull(sut.getState());
        assertEquals(StateValue.FINAL, sut.getState().getStateValue());
    }
}
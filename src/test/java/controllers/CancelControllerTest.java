package controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import models.Game;
import models.State;
import models.StateValue;

public class CancelControllerTest {


    @Test
    public void givenOpenGameStateWhenCancelThenFinishGame() {
        final Game game = new Game();
        final State state = new State(StateValue.OPEN_GAME);
        CancelController sut = new CancelController(game,state);
        sut.cancel();
        assertNotNull(sut.getState());
        assertEquals(StateValue.FINISH, sut.getState().getStateValue());
    }
}
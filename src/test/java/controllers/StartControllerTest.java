package controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import models.Game;
import models.State;
import models.StateValue;

public class StartControllerTest {


    @Test
    public void givenInitialStateWhenStartThenStartNewGame() {
        final Game game = new Game();
        final State state = new State(StateValue.INITIAL);
        StartController sut = new StartController(game,state);
        sut.start();
        assertNotNull(sut.getState());
        assertEquals(StateValue.OPEN_GAME, sut.getState().getStateValue());
    }
}
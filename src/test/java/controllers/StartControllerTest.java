package controllers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import models.Game;
import models.State;
import types.StateValue;

public class StartControllerTest {


    @Test
    public void givenInitialGameWhenStartThenStartGame() {
        final Game game = new Game();
        final State state = new State();
        StartController sut = new StartController(game,state);
        sut.start();
        assertNotNull(sut.getState());
        assertEquals(StateValue.OPENED_GAME, sut.getState().getStateValue());
    }
}
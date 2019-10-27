package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import models.State;
import models.Game;
import types.StateValue;

public class ResumeControllerTest {

    @Test
    public void givenOpenedGameWhenResponseNewGameThenReplay() {
        final Game game = new Game();
        final State state = new State();
        state.next();
        ResumeController sut = new ResumeController(game, state);
        sut.resume(true);
        assertNotNull(sut.getState());
        assertEquals(StateValue.INITIAL, sut.getState().getStateValue());
    }

    @Test
    public void givenOpenedGameWhenResponseFinishGameThenFinish(){
        final Game game = new Game();
        final State state = new State();
        state.next();
        ResumeController sut = new ResumeController(game, state);
        sut.resume(false);
        assertNotNull(sut.getState());
        assertEquals(StateValue.EXIT, sut.getState().getStateValue());
    }
}
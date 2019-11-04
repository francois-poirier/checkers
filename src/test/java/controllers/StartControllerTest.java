package controllers;


import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import models.Game;
import types.State;

@RunWith(MockitoJUnitRunner.class)
public class StartControllerTest {


	@Mock
	private Game game;
	

    @InjectMocks
    private StartController sut;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    

    @Test
    public void givenStartControllerWhenStartThenPlay() {
    	when(sut.getState()).thenReturn(State.INITIAL);
        sut.start();
        verify(game).setState(State.OPENED_GAME);
    }
}
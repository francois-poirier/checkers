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
public class ResumeControllerTest {
	
	@Mock
	private Game game;
	
    @InjectMocks
    private ResumeController sut;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenResumeControllerWhenResumeThenReplay() {
    	when(sut.getState()).thenReturn(State.FINAL);
        sut.resume(true);
        verify(game).clear();
    }

    @Test
    public void givenResumeControllerWhenNotResumeThenReplay() {
    	when(sut.getState()).thenReturn(State.FINAL);
        sut.resume(false);
        verify(game).setState(State.EXIT);
    }
}
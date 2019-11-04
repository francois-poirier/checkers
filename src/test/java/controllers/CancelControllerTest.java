package controllers;


import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import models.Game;

@RunWith(MockitoJUnitRunner.class)
public class CancelControllerTest {

	@Mock
	private Game game;
	
	
    @InjectMocks
    private CancelController sut;
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenCancelControllerWhenCancelThenStopGame() {
        sut.cancel();
        verify(game).cancel();
    }
}
package views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import controllers.PlayController;
import models.Color;
import models.Coordinate;
import types.State;
import utils.Console;

@RunWith(MockitoJUnitRunner.class)
public class CommandViewTest {

    @Mock
    PlayController playController;

    @Mock
    Console console;

    @InjectMocks
    CommandView commandView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void givenCommandViewWhenMovementRequiereCorrectThenNotError() {
        when(console.readChar(CommandView.OPTIONS)).thenReturn('1');
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("21.30\n");
        commandView.interact(playController);
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
        verify(playController).getStringBoard();
    }

    @Test
    public void givenCommandViewWhenMovementIsFinishContraryPlayerRequiereNextStateThenNotError() {
        when(console.readChar(CommandView.OPTIONS)).thenReturn('1');
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("21.30\n");
        when(playController.isFinish()).thenReturn(true);
        commandView.interact(playController);
        verify(playController).setState(State.FINAL);
        verify(playController).getStringBoard();
    }

    @Test(expected = NumberFormatException.class)
    public void givenCommandViewWhenMovementCoordinatesAreNotNumberThenException() {
        when(console.readChar(CommandView.OPTIONS)).thenReturn('1');
        when(playController.getColor()).thenReturn(Color.BLACK);
        when(console.readString("Mueven las negras: ")).thenReturn("2X.30\n");
        commandView.interact(playController);
        verify(playController).move(new Coordinate(2,1), new Coordinate(3, 0));
    }
    
    @Test
    public void givenCommandViewWhenChooseCancelOptionThenIsCancelled() {
    	when(console.readChar(CommandView.OPTIONS)).thenReturn('2');
        commandView.interact(playController);
        verify(playController).setState(State.FINAL);
    }
    

}
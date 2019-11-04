package views;

import org.junit.Before;
import org.junit.Test;

import controllers.StartController;
import models.Game;

public class BoardViewTest {
	
   
    BoardView boardView;

    @Before
    public void initMocks() {
        this.boardView = new BoardView(new StartController(new Game()));
    }
    
    @Test
    public void givenBoarViewWhenThenWrite() {
    	boardView.write();
    }
}

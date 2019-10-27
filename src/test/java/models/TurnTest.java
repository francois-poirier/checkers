package models;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TurnTest {

    
    @Test
    public void givenBlackTurnWhenMoveThenTurnChanged(){
      final Turn sut = new Turn(Color.BLACK);
      sut.change();
      assertTrue(sut.isWhiteTurn());
    }

    @Test
    public void givenWhiteTurnWhenMoveThenTurnChanged(){
        final Turn sut = new Turn(Color.WHITE);
        sut.change();
        assertTrue(sut.isBlackTurn());
    }

    
}
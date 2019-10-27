package models;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class SquareTest {

	
	@Test
	public void givenSquareWhenPieceWantToMoveToThisSquareThenCheckIsEmpty() {
        final Square sut = new Square();
		assertTrue(sut.isEmpty());
    }
    
    @Test
	public void givenSquareWhenPieceWantToMoveToThisSquareThenCheckIsNotEmpty() {
        final Square sut = new Square();
        sut.setPiece(new Pawn(Color.WHITE));
		assertFalse(new Square().isEmpty());
	}
	
}
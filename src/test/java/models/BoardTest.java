package models;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {

    @Test
    public void givenBoardWhenAskWhitePawnReachGoalThenCheckPositionPawn() {
        final Board board = new Board();
        final Pawn pawn = new Pawn(Color.WHITE);
        assertTrue(board.isEndBoard(pawn.getPosition()));
    }

    @Test
    public void givenBoardWhenAskBlackPawnReachGoalThenCheckPositionPawn() {
        final Board board = new Board();
        final Pawn pawn = new Pawn(Color.BLACK);
        assertTrue(board.isEndBoard(pawn.getPosition()));
    }

    @Test
    public void givenBoardWhenWhitePawnReachGoalThenTransformIntoQueen(){
        final Board board = new Board();
        final Pawn pawn = new Pawn(Color.WHITE);
        final Queen queen = board.transform(pawn);     
        assertNotNull(queen); 
        assertTrue(Color.WHITE == queen.getColor());
    }

    @Test
    public void givenBoardWhenBlackPawnReachGoalThenTransformIntoQueen(){
        final Board board = new Board();
        final Pawn pawn = new Pawn(Color.BLACK);
        final Queen queen = board.transform(pawn);     
        assertNotNull(queen); 
        assertTrue(Color.BLACK == queen.getColor());
    }
}
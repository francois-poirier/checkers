package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QueenTest {


    @Test
    public void givenPieceColorWhenGetColorThenReturnTheSameColor() {
       final Queen piece = new Queen(Color.WHITE);
       assertEquals(Color.WHITE, piece.getColor());
    }

    @Test
    public void givenPieceTypeWhenGetTypeThenReturnTheSameType() {
        final Queen piece = new Queen(Color.WHITE);
        assertEquals(PieceType.QUEEN, piece.getType());
    }
}
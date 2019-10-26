package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PawnTest {


    @Test
    public void givenPieceColorWhenGetColorThenReturnTheSameColor() {
       final Pawn piece = new Pawn(Color.WHITE);
       assertEquals(Color.WHITE, piece.getColor());
    }

    @Test
    public void givenPieceTypeWhenGetTypeThenReturnTheSameType() {
        final Pawn piece = new Pawn(Color.WHITE);
        assertEquals(PieceType.QUEEN, piece.getType());
    }
}
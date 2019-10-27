
package models;

import org.junit.Test;

import types.PieceType;

import static org.junit.Assert.*;

public class PieceTest {

    @Test
    public void givenPieceWhenAskColorThenReturnValue() {
        Piece sut = new Pawn(Color.BLACK);
        assertEquals(Color.BLACK, sut.getColor());
    }


    @Test
    public void givenPieceWhenAskTypeThenReturnValue() {
        Piece sut = new Pawn(Color.WHITE);
        assertEquals(PieceType.PAWN, sut.getType());
    }

    @Test
    public void givenPieceWhenSetTypeThenInitValueCorrectly() {
        Piece sut = new Pawn(Color.BLACK);
        assertEquals("setType(PAWN)", PieceType.PAWN, sut.getType());
        sut = new Queen(Color.BLACK);
        assertEquals("setType(QUEEN)", PieceType.QUEEN, sut.getType());
    }
}
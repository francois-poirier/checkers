package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BoardTest {


    private Board board;
    

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGivenNewBoardThenGoodLocationsWhitePieces() {
        Coordinate[] coordinates = new Coordinate[] {new Coordinate(5, 0), new Coordinate(6, 5), new Coordinate(7, 6)};
        this.checkCoordinatesByColorPiece(coordinates, Color.WHITE);
    }

    @Test
    public void testGivenNewBoardThenGoodLocationsBlackPieces() {
        Coordinate[] coordinates = new Coordinate[] {new Coordinate(0, 1), new Coordinate(1, 4), new Coordinate(2, 7)};
        this.checkCoordinatesByColorPiece(coordinates, Color.BLACK);
    }

    private void checkCoordinatesByColorPiece(Coordinate[] coordinates, Color color) {
        for (Coordinate coordinate : coordinates) {
            Color colorPiece = board.getColor(coordinate);
            assertEquals(color, colorPiece);
        }
    }
    


    @Test(expected = AssertionError.class)
    public void testGivenNewBoardWhenRemoveAPieceThatNotExistThenException() {
        Coordinate coordinate = new Coordinate(0, 4);
        this.board.remove(coordinate);
    }

    @Test
    public void testGivenNewBoardWhenRemoveAPieceThenIsRemoved() {
        Coordinate coordinate = new Coordinate(0, 5);
        this.board.remove(coordinate);
        assertTrue(this.board.isEmpty(coordinate));
    }

    @Test
    public void testGivenGameWhenThereAreMovementsThenGetFalse() {
        assertFalse(board.noMoreMoves(Color.BLACK));
        assertFalse(board.noMoreMoves(Color.WHITE));
    }

    @Test
    public void testGivenGameWhenThereArePiecesThenGetFalse() {
        assertFalse(board.noMorePieces(Color.BLACK));
        assertFalse(board.noMorePieces(Color.WHITE));
    }
}
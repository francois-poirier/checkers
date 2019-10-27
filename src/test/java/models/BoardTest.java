package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    private Board sut;

    @Before
    public void before() {
        sut = new Board();
    }

    @Test
    public void givenBoardWhenGetPieceInCoordinateThenReturn() {
        Coordinate coordinate = new Coordinate(1, 6);
        assertNotNull(this.sut.getPiece(coordinate));
    }

    @Test
    public void givenBoardWhenGetPieceInCoordinateIsOutOfTheBoardThenReturnError() {
        Coordinate coordinate = new Coordinate(1, 9);
        assertNull(this.sut.getPiece(coordinate));
    }

    @Test
    public void givenBoardWhenMoveToANonExistPositionThenReturnError() {
        Coordinate origin = new Coordinate(4, 3);
        Coordinate target = new Coordinate(10, 1);
        assertNotNull(this.sut.movePiece(origin, target));
    }

    @Test
    public void givenBoardWhenMoveToCorrectPositionThenNotReturnError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(2, 5);
        assertNull(this.sut.movePiece(origin, target));
        assertNull(this.sut.getPiece(origin));
        Piece targetPiece = this.sut.getPiece(target);
        assertNotNull(targetPiece);
        assertEquals(Color.WHITE, targetPiece.getColor());
    }

    
    @Test
    public void givenBoardWhenMoveToNotEmptyPositionThenReturnError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(2, 5);
        Coordinate contraryOrigin = new Coordinate(4, 3);
        Coordinate contraryFirstMove = new Coordinate(3, 4);
        Piece originPiece = sut.getPiece(origin);
        Piece targetpiece = sut.getPiece(target);
        assertNull(this.sut.movePiece(contraryOrigin, contraryFirstMove));
        assertNull(this.sut.movePiece(contraryFirstMove, target));
        assertNotNull(this.sut.movePiece(origin, target));
        assertNotNull(originPiece);
        assertNotNull(targetpiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertEquals(Color.WHITE, targetpiece.getColor());
    }

    @Test
    public void givenBoardWhenMovePawnToAPreviousPositionThenReturnError() {
        Coordinate firstMove = new Coordinate(2, 5);
        Coordinate origin = new Coordinate(1, 6);
        assertNull(this.sut.movePiece(origin, firstMove));
        assertNotNull(this.sut.movePiece(firstMove, origin));
        Piece pawnOrigin = this.sut.getPiece(firstMove);
        assertNotNull(pawnOrigin);
        assertEquals(Color.WHITE, pawnOrigin.getColor());
        assertNull(this.sut.getPiece(origin));
    }


    @Test
    public void givenBoardWhenMovePieceToAStraightPositionThenReturnError() {
        Coordinate origin = new Coordinate(1, 6);
        Coordinate target = new Coordinate(1, 5);
        Piece pawnOrigin = (Piece) sut.getPiece(origin);
        assertNotNull(this.sut.movePiece(origin, target));
        assertNotNull(pawnOrigin);
        assertEquals(Color.WHITE, pawnOrigin.getColor());
        assertNull(this.sut.getPiece(target));
        this.checkFinalPositionQueen(this.sut, origin, target);
    }

    @Test
    public void givenBoardWhenEatAnotherPieceRequiereCorrectThenReturnNotError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(3, 4);
        Coordinate positionContraryPiece = new Coordinate(2, 5);
        Piece originPiece = sut.getPiece(originPositionOwnPiece);
        Piece contraryPiece = sut.getPiece(positionContraryPiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertEquals(Color.BLACK, contraryPiece.getColor());
        assertNull(this.sut.movePiece(originPositionOwnPiece, targetPositionOwnPiece));
        assertNull(this.sut.getPiece(originPositionOwnPiece));
        assertNull(this.sut.getPiece(positionContraryPiece));
        Piece pieceTarget = this.sut.getPiece(targetPositionOwnPiece);
        assertNotNull(pieceTarget);
        assertEquals(Color.WHITE, pieceTarget.getColor());
    }

    @Test
    public void givenBoardWhenAPawnEatAnotherPieceWithoutPieceBetweenThenReturnError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(3, 4);
        Piece originPiece = sut.getPiece(originPositionOwnPiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertNotNull(this.sut.movePiece(originPositionOwnPiece, targetPositionOwnPiece));
        assertNotNull(this.sut.getPiece(originPositionOwnPiece));
        Piece pieceTarget = this.sut.getPiece(targetPositionOwnPiece);
        assertNull(pieceTarget);
    }

    @Test
    public void givenBoardWhenEatAnotherPieceWithPieceOfTheSameColorBetweenThenReturnError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(3, 4);
        Coordinate positionContraryPiece = new Coordinate(2, 5);
        Piece originPieceBeforeMove = sut.getPiece(originPositionOwnPiece);
        Piece contraryPieceBeforeMove = sut.getPiece(positionContraryPiece);
        assertEquals(Color.WHITE, originPieceBeforeMove.getColor());
        assertEquals(Color.WHITE, contraryPieceBeforeMove.getColor());
        assertNotNull(this.sut.movePiece(originPositionOwnPiece, targetPositionOwnPiece));
        assertNotNull(this.sut.getPiece(positionContraryPiece));
        Piece originPieceAfterMove = this.sut.getPiece(originPositionOwnPiece);
        assertNotNull(originPieceAfterMove);
        assertEquals(Color.WHITE, originPieceAfterMove.getColor());
        Piece contraryPieceAfterMove = this.sut.getPiece(positionContraryPiece);
        assertNotNull(contraryPieceAfterMove);
        assertEquals(Color.WHITE, contraryPieceAfterMove.getColor());
        assertNull(this.sut.getPiece(targetPositionOwnPiece));
    }

    @Test
    public void givenBoardWhenATurnWantToMoveMoreThanOneTimeInCorrectThenReturnError() {
        Coordinate originPositionOwnPiece = new Coordinate(1, 6);
        Coordinate targetPositionOwnPiece = new Coordinate(2, 5);
        Coordinate originPositionSecondOwnPiece = new Coordinate(3, 6);
        Coordinate targetPositionSecondOwnPiece = new Coordinate(4, 5);
        Piece originPiece = sut.getPiece(originPositionOwnPiece);
        assertEquals(Color.WHITE, originPiece.getColor());
        assertNull(sut.movePiece(originPositionOwnPiece, targetPositionOwnPiece));
        Piece targetPiece = this.sut.getPiece(targetPositionOwnPiece);
        assertNotNull(targetPiece);
        assertEquals(Color.WHITE, targetPiece.getColor());
        Piece originSecondPiece = this.sut.getPiece(originPositionSecondOwnPiece);
        assertEquals(Color.WHITE, originSecondPiece.getColor());
        assertNotNull(this.sut.movePiece(originPositionSecondOwnPiece, targetPositionSecondOwnPiece));
        assertNull(this.sut.getPiece(targetPositionSecondOwnPiece));
    }


    private void checkFinalPositionQueen(Board sut, Coordinate origin, Coordinate target) {
        Piece queenOrigin = sut.getPiece(origin);
        assertNull(queenOrigin);
        Piece targetQueen = sut.getPiece(target);
        assertNotNull(targetQueen);
        assertEquals(Color.WHITE, targetQueen.getColor());
    }

}
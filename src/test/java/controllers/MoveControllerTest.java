package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import models.Color;
import models.Coordinate;
import models.Game;
import models.Piece;
import models.State;
import types.Error;
import types.StateValue;

public class MoveControllerTest {


    @Test
    public void givenOpenedGameWhenMoveAndSquareEmptyThenContinueGame() {
        final Game game = new Game();
        final State state = new State();
        state.next();
        MoveController sut = new MoveController(game,state);
        Coordinate origin = new Coordinate(2, 1);
        Coordinate target = new Coordinate(3, 2);
        Error error = sut.move(origin, target);
        assertNull(error);
        assertNull(sut.getPiece(origin));
        Piece pieceTarget = sut.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void givenOpenedGameWhenMoveAndSquareNotEmptyThenKO() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(7, 2);
        Coordinate target = new Coordinate(6, 3);
        MoveController sut = new MoveController(game, state);
        assertEquals(sut.move(origin, target), Error.SQUARE_NOT_EMPTY);
    }

    @Test
    public void givenOpenedGameWhenMoveOutOffBoardThenReturnOut() {
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(6, 7);
        Coordinate target = new Coordinate(8, 8);
        MoveController sut = new MoveController(game, state);
        assertEquals(Error.OUT_BOARD,sut.move(origin, target));
    }

    @Test
    public void givenOpenedGameWhenMoveAndNotWinThenContinueGame(){
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(1, 1);
        MoveController sut = new MoveController(game, state);
        sut.move(origin, target);
        assertNull(sut.getWinner());
        assertEquals(StateValue.OPENED_GAME, state.getStateValue());
    }

    @Test
    public void givenOpenedGameWhenMoveAndWinThenFinishGame(){
        Game game = new Game();
        State state = new State();
        Coordinate origin = new Coordinate(2, 0);
        Coordinate target = new Coordinate(1, 1);
        MoveController sut = new MoveController(game, state);
        sut.move(origin, target);
        assertNotNull(sut.getWinner());
        assertEquals(StateValue.FINAL, state.getStateValue());
    }

}
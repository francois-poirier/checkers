package controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import models.Coordinate;
import models.Game;
import types.Error;

public class MoveControllerTest {


    @Test
    public void givenOpenedGameWhenMoveAndSquareNotEmptyThenKO() {
        Game game = new Game();
        Coordinate origin = new Coordinate(7, 2);
        Coordinate target = new Coordinate(6, 3);
        MoveController sut = new MoveController(game);
        assertEquals(Error.NOT_EMPTY_TARGET, sut.move(origin, target));
    }

    @Test
    public void givenOpenedGameWhenMoveOutOffBoardThenReturnOut() {
        Game game = new Game();
        Coordinate origin = new Coordinate(6, 7);
        Coordinate target = new Coordinate(8, 8);
        MoveController sut = new MoveController(game);
        assertEquals(Error.OUT_COORDINATE,sut.move(origin, target));
    }


}
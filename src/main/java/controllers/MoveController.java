package controllers;

import models.Coordinate;
import models.Game;
import types.Error;

public class MoveController extends Controller {

    MoveController(Game game) {
        super(game);
    }

    public Error move(Coordinate origin, Coordinate target) {
        return game.move(origin, target);
    }

}
package controllers;

import models.Game;
import models.Piece;
import models.State;
import models.Color;
import models.Coordinate;
import types.Error;

public class MoveController extends Controller {

    MoveController(Game game, State state) {
        super(game,state);
    }

    public Error move(Coordinate origin, Coordinate target) {
        return null;
    }

    public Piece getPiece(Coordinate origin) {
		return null;
	}

	public Color getWinner() {
		return null;
    }
}
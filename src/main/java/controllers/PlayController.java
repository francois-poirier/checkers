package controllers;

import models.Game;
import models.Coordinate;
import models.Piece;

class PlayController extends AcceptorController {

    public PlayController(Game game) {
		super(game);
	}

	public Error move(Coordinate origin, Coordinate target){
        return null;
    }

	public Piece getPiece(Coordinate origin) {
		return null;
	}
}
package controllers;

import models.Game;
import models.Coordinate;
import models.Piece;
import models.State;
import types.Error;

class PlayController extends AcceptorController {

    public PlayController(Game game, State state) {
		super(game,state);
	}

	public Error move(Coordinate origin, Coordinate target){
        return null;
    }

	public Piece getPiece(Coordinate origin) {
		return null;
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}
}
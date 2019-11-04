package controllers;

import models.Coordinate;
import models.Game;
import models.Piece;
import types.State;

public class StartController extends AcceptorController {

    public StartController(Game game) {
        super(game);
    }
    
    public void start() {
    	assert this.getState() == State.INITIAL;
    	this.setState(State.OPENED_GAME);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

	public Piece getPiece(Coordinate coordinate) {
		return this.getGame().getBoard().getPiece(coordinate);
	}
    
}
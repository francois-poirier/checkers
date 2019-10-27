package controllers;

import models.Game;
import models.State;

public class StartController extends AcceptorController {

    public StartController(Game game, State state) {
        super(game,state);
    }
    
    public void start() {

    }

	public State getState() {
		return null;
	}

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
}
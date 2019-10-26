package controllers;

import models.Game;
import models.State;

public class StartController extends AcceptorController {

    public StartController(Game game, State state) {
        super(game);
    }
    
    public void start() {

    }

	public State getState() {
		return null;
	}
}
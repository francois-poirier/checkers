package controllers;

import models.Game;
import models.State;

public class ResumeController extends AcceptorController {

    public ResumeController(Game game, State state) {
        super(game);
    }
    
    public void resume(boolean newGame) {
    }

	public State getState() {
		return null;
	}
}
package controllers;

import models.Game;
import models.State;

public class CancelController extends Controller {
    
    public CancelController(Game game, State state) {
        super(game,state);
    }

    public void cancel() {

    }

	public State getState() {
		return null;
	}
}
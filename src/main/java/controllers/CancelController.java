package controllers;

import models.Game;

public class CancelController extends Controller {
    
    public CancelController(Game game) {
        super(game);
    }

    public void cancel() {
    	game.cancel();
    }

}
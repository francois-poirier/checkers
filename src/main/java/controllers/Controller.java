package controllers;

import models.Game;
import types.State;

public abstract class Controller {
    protected Game game;

    public Controller(Game game){
        this.game = game;
    }
    
	protected State getState(){
		return game.getState();
	}
	
	public void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public String getStringBoard() {
		return this.game.getBoard().toString();
	}
}
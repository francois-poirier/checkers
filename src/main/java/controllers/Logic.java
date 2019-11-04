package controllers;

import java.util.HashMap;
import java.util.Map;

import models.Game;
import types.State;

public class Logic {
    private Game game;


    private Map<State, AcceptorController> acceptorControllers;

    public Logic() {
		this.game = new Game();
		this.acceptorControllers = new HashMap<State, AcceptorController>();
		this.acceptorControllers.put(State.INITIAL, new StartController(game));
		this.acceptorControllers.put(State.OPENED_GAME, new PlayController(game));
		this.acceptorControllers.put(State.FINAL, new ResumeController(game));
		this.acceptorControllers.put(State.EXIT, null);
	}
	
	public AcceptorController getController() {
		return this.acceptorControllers.get(this.game.getState());
	}
}
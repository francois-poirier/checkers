package controllers;

import java.util.HashMap;
import java.util.Map;
import models.Game;
import models.State;
import types.StateValue;

public class Logic {
    private Game game;
    private State state;

    private Map<StateValue, AcceptorController> acceptorControllers;

    public Logic() {
        this.state = new State();
		this.game = new Game();
		this.acceptorControllers = new HashMap<StateValue, AcceptorController>();
		this.acceptorControllers.put(StateValue.INITIAL, new StartController(game,state));
		this.acceptorControllers.put(StateValue.OPENED_GAME, new PlayController(game,state));
		this.acceptorControllers.put(StateValue.FINAL, new ResumeController(game,state));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}
	
	public AcceptorController getController() {
		return this.acceptorControllers.get(this.state.getStateValue());
	}
}
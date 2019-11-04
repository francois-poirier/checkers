package controllers;

import models.Game;
import types.State;

public class ResumeController extends AcceptorController {

    public ResumeController(Game game) {
        super(game);
    }
    

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
       controllersVisitor.visit(this);
    }


	public void resume(boolean newGame) {
		assert this.game.getState()==State.FINAL;
        if (newGame) {
			this.game.clear();
		} else {
			this.game.setState(State.EXIT);
		}
	}
}
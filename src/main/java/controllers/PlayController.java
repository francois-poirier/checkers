package controllers;

import models.Color;
import models.Coordinate;
import models.Game;
import types.Error;

public class PlayController extends AcceptorController {

	private MoveController moveController;
	private CancelController cancelController;
	
    public PlayController(Game game) {
		super(game);
		this.moveController = new MoveController(game);
		this.cancelController = new CancelController(game);
	}

	public Error move(Coordinate origin, Coordinate target){
        return moveController.move(origin, target);
    }

	public void cancel() {
		cancelController.cancel();
	}
	
	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

	public Color getColor() {
		return this.game.getTurn().getColor();
	}

	public boolean isFinish() {
		return this.game.isFinish();
	}


}
package controllers;

import models.Game;
import models.State;

public abstract class AcceptorController extends Controller {

    AcceptorController(Game game, State state) {
        super(game,state);
    }

    public abstract void accept(ControllersVisitor controllersVisitor);
}
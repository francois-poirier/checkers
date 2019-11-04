package controllers;

import models.Game;

public abstract class AcceptorController extends Controller {

    AcceptorController(Game game) {
        super(game);
    }

    public abstract void accept(ControllersVisitor controllersVisitor);
}
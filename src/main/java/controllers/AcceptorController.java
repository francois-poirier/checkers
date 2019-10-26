package controllers;

import models.Game;

public abstract class AcceptorController extends Controller {

    AcceptorController(Game game) {
        super(game);
    }
}
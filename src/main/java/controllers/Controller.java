package controllers;

import models.Game;
import models.State;

abstract class Controller {
    protected Game game;
    protected State state;

    Controller(Game game, State state){
        this.game = game;
        this.state = state;
    }
}
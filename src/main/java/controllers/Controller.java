package controllers;

import models.Game;

abstract class Controller {
    protected Game game;
    
    Controller(Game game) {
       this.game = game;
    }
}
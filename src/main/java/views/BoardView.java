package views;

import controllers.Controller;
import models.Board;
import models.Coordinate;
import models.Piece;
import utils.Console;

public class BoardView {

	private Console console;
	private Controller controller;

	public BoardView(Controller controller) {
		this.controller = controller;
		this.console = new Console();
	}

	public void write() {
		console.writeln();
		String string = getNumRows();
		for (int i = 0; i < Board.DIMENSION; i++) {
			string += i+1;
			for (int j = 0; j < Board.DIMENSION; j++) {
				Piece piece = this.controller.getGame().getBoard().getPiece(new Coordinate(i,j));
				if (piece == null) {
					string += " ";
				} else if (piece.isBlack()) {
					string += "n";
				} else {
					string += "b";
				}
			}
			string += i+1 + "\n";
		}
		string +=  getNumRows();
		console.write(string);
	}

	private String getNumRows() {
		String string = " ";
		for (int j = 0; j < Board.DIMENSION; j++) {
			string += j+1;
		}
		string += "\n";
		return string;
	}

}

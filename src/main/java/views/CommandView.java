package views;

import utils.Console;
import controllers.PlayController;
import models.Coordinate;
import types.Error;
import types.State;

public class CommandView {

	private Console console;

	private static final String[] COLORS = { "blancas", "negras" };
	public static final String LOST_GAME = "Derrota!!! No puedes mover tus fichas!!!";
	public static final String COMMAND_MOVE = "1) Mover";
	public static final String COMMAND_CANCEL = "2) Cancelar";
	public static final String OPTIONS = "Elige opción: ";

	public CommandView() {
		this.console = new Console();
	}

	public void interact(PlayController playController) {
		Error errorOption;

		do {
			errorOption = null;
			this.console.writeln(COMMAND_MOVE);
			this.console.writeln(COMMAND_CANCEL);
			char option = this.console.readChar(OPTIONS);
			switch (option) {
			  case '1':
					Error error = null;
					String color = CommandView.COLORS[playController.getColor().ordinal()];
					do {
						String moveOption = this.console.readString("Mueven las " + color + ": ");
						int originRow = Integer.parseInt(moveOption.substring(0, 1));
						int originColumn = Integer.parseInt(moveOption.substring(1, 2));
						int targetRow = Integer.parseInt(moveOption.substring(3, 4));
						int targetColumn = Integer.parseInt(moveOption.substring(4, 5));
						error = playController.move(new Coordinate(originRow, originColumn),
								new Coordinate(targetRow, targetColumn));
						if (error != null) {
							console.writeln(error.getText());
						}
					} while (error != null);
					this.console.writeln();
					this.console.writeln(playController.getStringBoard());
					if (playController.isFinish()) {
						playController.setState(State.FINAL);
						this.console.writeln(LOST_GAME);
					}
				  break;
			  case '2':
				  playController.setState(State.FINAL);
				  break;
			  default:
					errorOption = Error.WRONG_OPTION;
					console.writeln(errorOption.getText());
				  break;
			}
		} while (errorOption != null);
	}

}
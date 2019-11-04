package views;

import controllers.StartController;
import utils.Console;

public class StartView {

	public static final String INITIAL_MESSAGE = "Las Damas!!!";
	
    private Console console;

	public StartView() {
        this.console = new Console();
    }
	
	
	void interact(StartController startController){
		console.writeln(INITIAL_MESSAGE);
		startController.start();
		this.console.writeln(startController.getStringBoard());
	}
	
}

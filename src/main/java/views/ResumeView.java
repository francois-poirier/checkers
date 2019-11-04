package views;

import controllers.ResumeController;
import utils.Console;

public class ResumeView {
	
	public static final String QUESTION = "¿Queréis jugar otra? (s/n):";
	public static final char AFIRMATIVE = 's';
    public static final char NEGATIVE = 'n';
	
    private Console console;

	public ResumeView() {
		this.console = new Console();
	}

	public void interact(ResumeController resumeController) {
		char answer;
		do {
			answer = this.console.readChar(ResumeView.QUESTION);
		} while (!(ResumeView.isAfirmative(answer) || ResumeView.isNegative(answer)));
		boolean newGame = answer == AFIRMATIVE ?  true : false;
	    resumeController.resume(newGame);			
	}
	
	private static boolean isAfirmative(char answer) {
		return Character.toLowerCase(answer) == ResumeView.AFIRMATIVE;
	}

	private static boolean isNegative(char answer) {
		return Character.toLowerCase(answer) == ResumeView.NEGATIVE;
	}
}

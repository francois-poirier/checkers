package models;

public class Turn {

    private Color color;
    
    public Turn(Color color) {
        this.color=color;
    }
    
	public void change() {
        if (this.color==Color.WHITE) {
			this.color = Color.BLACK;
		} else {
			this.color = Color.WHITE;
		}
	}

	public boolean isWhiteTurn() {
		return color == Color.WHITE;
	}

	public boolean isBlackTurn() {
		return color == Color.BLACK;
	}

}
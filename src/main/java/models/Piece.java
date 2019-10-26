package models;

public abstract class Piece {

	protected Coordinate position;
	protected Color color;
	protected PieceType type;

	public Piece(Color color, PieceType pieceType) {
	}

	public Color getColor() {
		return null;
	}

	public PieceType getType()  {
		return null;
	}

	public abstract Coordinate getPosition();

	public abstract Piece move(Coordinate source, Coordinate target);

}
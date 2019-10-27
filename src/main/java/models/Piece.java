package models;

import types.PieceType;

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

	public void setType(PieceType type) {
	}

}
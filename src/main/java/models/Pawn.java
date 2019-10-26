package models;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color, PieceType.PAWN);
    }

    @Override
    public Coordinate getPosition() {
        return null;
    }

    @Override
    public Piece move(Coordinate source, Coordinate target) {
        return null;
    }

}
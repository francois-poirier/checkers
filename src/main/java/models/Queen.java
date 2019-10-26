package models;

public class Queen extends Piece {

    public Queen(Color color) {
        super(color, PieceType.QUEEN);
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
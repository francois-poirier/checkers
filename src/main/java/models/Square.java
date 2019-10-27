package models;

public class Square {

    private Piece piece;
    
    public Square() {

    }

    public boolean isEmpty() {
        return piece==null;
    }

    public void setPiece(Piece piece) {
      this.piece = piece;
    }

    public Piece getPiece() {
      return piece;
    }

}
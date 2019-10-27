package models;

public class Coordinate {

    private final int row;
    private final int column;
    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

	public int getRow() {
		return row;
	}

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && (obj.getClass().equals(this.getClass()))) {
            Coordinate pos = (Coordinate) obj;
            return (this.row == pos.getRow() && this.column == pos.getColumn());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.row;
        hash = 47 * hash + this.column;
        return hash;
    }
}
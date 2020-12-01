package model.pieces;

public class Knight extends ChessPiece {
    public Knight(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.color == 'w') {
            return "n";
        } else {
            return "N";
        }
    }
}

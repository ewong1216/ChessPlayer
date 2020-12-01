package model.pieces;

public class Pawn extends ChessPiece {

    public Pawn(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.color == 'w') {
            return "p";
        } else {
            return "P";
        }
    }
}

package model.pieces;

import model.Square;

public class Rook extends ChessPiece {
    public Rook(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.color == 'w') {
            return "r";
        } else {
            return "R";
        }
    }
}

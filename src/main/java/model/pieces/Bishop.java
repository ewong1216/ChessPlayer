package model.pieces;

import model.Square;

public class Bishop extends ChessPiece {
    public Bishop(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.color == 'w') {
            return "b";
        } else {
            return "B";
        }
    }
}

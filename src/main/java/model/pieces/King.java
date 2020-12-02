package model.pieces;

import model.Square;

public class King extends ChessPiece {
    public King(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public boolean canCapture(Square start, Square enemy) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.getColor() == 'w') {
            return "k";
        } else {
            return "K";
        }
    }
}

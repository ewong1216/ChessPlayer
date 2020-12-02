package model.pieces;

import model.Square;

public class Knight extends ChessPiece {
    public Knight(char color) {
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
            return "n";
        } else {
            return "N";
        }
    }
}

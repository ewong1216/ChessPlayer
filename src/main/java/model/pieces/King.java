package model.pieces;

import model.Square;

public class King extends ChessPiece {
    public King(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.color == 'w') {
            return "k";
        } else {
            return "K";
        }
    }
}

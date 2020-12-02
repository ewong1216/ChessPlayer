package model.pieces;

import model.Square;

public abstract class ChessPiece {
    private char color;
    private boolean hasMoved;

    public ChessPiece(char color) {
        this.color = color;
    }

    public abstract boolean canMoveTo(Square start, Square finish);

    public abstract boolean canCapture(Square start, Square enemy);

    public boolean hasMoved() {
        return hasMoved;
    }

    public char getColor() {
        return color;
    }
    public abstract void moveTo(Square square);

}

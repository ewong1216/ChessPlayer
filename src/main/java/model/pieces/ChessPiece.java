package model.pieces;

import model.Square;

public abstract class ChessPiece {
    protected int color;

    public ChessPiece(char color) {
        this.color = color;
    }

    public abstract boolean canMoveTo(Square start, Square finish);

    public abstract void moveTo(Square square);
}

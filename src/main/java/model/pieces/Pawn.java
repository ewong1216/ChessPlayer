package model.pieces;

import model.Square;

public class Pawn extends ChessPiece {

    public Pawn(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        if(finish.isOccupied()) {
            return false;
        } else if(finish.getRank() == start.getRank() + move(1)) {
            return true;
        } else if(!super.hasMoved() && finish.getRank() == start.getRank() + move(2)) {
            return true;
        } else {
            return false;
        }
    }

    private int move(int numSquares) {
        if(super.getColor() == 'w'){
            return numSquares;
        } else {
            return -numSquares;
        }
    }

    public boolean canCapture(Square start, Square enemy) {
        if(enemy.getRank() == start.getRank() + move(1) && Math.abs(start.getFile() - enemy.getFile()) == 1) {
            return true;
        } else {
            return canEnPassant(start, enemy);
        }
    }

    private boolean canEnPassant(Square start, Square enemy) {
        throw new UnsupportedOperationException();
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.getColor() == 'w') {
            return "p";
        } else {
            return "P";
        }
    }
}

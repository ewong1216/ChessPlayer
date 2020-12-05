package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.Set;

public class Bishop extends ChessPiece {
    public Bishop(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    @Override
    public Set<Square> possibleMoves(Square start, ChessBoard board) {
        return null;
    }

    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        return null;
    }


    public String toString() {
        if(super.getColor() == 'w') {
            return "b";
        } else {
            return "B";
        }
    }
}

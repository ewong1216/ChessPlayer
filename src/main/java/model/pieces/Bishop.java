package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.HashSet;
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
        Set<Square> possibleMoves = new HashSet<>();
        possibleMoves.addAll(checkMovesInDirection(start, board,1,1));
        possibleMoves.addAll(checkMovesInDirection(start, board,1,-1));
        possibleMoves.addAll(checkMovesInDirection(start, board,-1,1));
        possibleMoves.addAll(checkMovesInDirection(start, board,-1,-1));
        return possibleMoves;
    }

    @Override
    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        Set<Square> possibleCaptures = new HashSet<>();
        checkCaptureInDirection(start, board,1,1,possibleCaptures);
        checkCaptureInDirection(start, board,1,-1,possibleCaptures);
        checkCaptureInDirection(start, board,-1,1,possibleCaptures);
        checkCaptureInDirection(start, board,-1,-1,possibleCaptures);
        return possibleCaptures;
    }


    public String toString() {
        if(super.getColor() == 'w') {
            return "b";
        } else {
            return "B";
        }
    }
}

package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.Set;

/**
 * Defines a chess King object.
 */
public class King extends ChessPiece {
    /**
     * Creates a new King instance with the given color.
     * @param color 'w' for a white King, 'b' for a black King.
     */
    public King(char color) {
        super(color);
    }

    /**
     * Calculates all of the possible moves this King can legally make.
     *
     * @param start the Square this King is on.
     * @param board the ChessBoard this King is in.
     * @return a Set<Square> of the possible squares this King can move to. Returns an empty set
     * if there are no legal moves.
     */
    @Override
    public Set<Square> possibleMoves(Square start, ChessBoard board) {
        return null;
    }

    /**
     * Calculates all of the possible captures this King can legally perform.
     * @param start the square from which the piece starts.
     * @param board the chess board that this piece is on.
     * @return a set of squares on which lie the capturable pieces. Returns an empty set if there are none.
     */
    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        return null;
    }

//    private Square checkSquareInDirection(Square start, ChessBoard board, int fileChange, int rankChange){
//        Square toCheck = board.getSquare(start.getFile() + fileChange, start.getRank() + rankChange);
//        if(toCheck == null){
//            return null;
//        }
//
//    }

    public String toString() {
        if(super.getColor() == 'w') {
            return "k";
        } else {
            return "K";
        }
    }
}

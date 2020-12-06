package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.HashSet;
import java.util.Set;

/**
 * Defines a chess Rook piece.
 */
public class Rook extends ChessPiece {

    /**
     * Creates a new Rook with the given color.
     * @param color the color of the Rook.
     */
    public Rook(char color) {
        super(color);
    }

    /**
     * Calculates all of the possible moves this Rook can legally make.
     *
     * @param start the Square this Rook is on.
     * @param board the ChessBoard this Rook is in.
     * @return a Set<Square> of the possible squares this rook can move to. Returns an empty set
     * if there are no legal moves.
     */
    public Set<Square> possibleMoves(Square start, ChessBoard board) {
        Set<Square> possibleMoves = new HashSet<>();
        possibleMoves.addAll(checkMovesInDirection(start, board, 0, 1));
        possibleMoves.addAll(checkMovesInDirection(start, board, 0, -1));
        possibleMoves.addAll(checkMovesInDirection(start, board, 1, 0));
        possibleMoves.addAll(checkMovesInDirection(start, board, -1, 0));
        return possibleMoves;
    }

    /**
     * Calculates all of the possible captures this rook can legally perform.
     *
     * @param start the square from which the Rook starts.
     * @param board the chess board this rook is on.
     * @return a set of squares on which lie the capturable pieces.
     */
    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        Set<Square> possibleCaptures = new HashSet<>();
        checkCaptureInDirection(start, board, 1, 0, possibleCaptures);
        checkCaptureInDirection(start, board, -1, 0, possibleCaptures);
        checkCaptureInDirection(start, board, 0, 1, possibleCaptures);
        checkCaptureInDirection(start, board, 0, -1, possibleCaptures);
        return possibleCaptures;
    }

    /**
     * Returns a String representation of this Rook.
     * @return "R" if a black rook, "r" if a white rook.
     */
    public String toString() {
        if(super.getColor() == 'w') {
            return "r";
        } else {
            return "R";
        }
    }
}

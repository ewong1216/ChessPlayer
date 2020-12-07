package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.HashSet;
import java.util.Set;

/**
 * Defines a chess Queen object.
 */
public class Queen extends ChessPiece {
    /**
     * Creates a new Queen instance with the given color.
     * @param color
     */
    public Queen(char color) {
        super(color);
    }

    /**
     * Calculates all of the possible moves this Queen can legally make.
     *
     * @param start the Square this Queen is on.
     * @param board the ChessBoard this Queen is in.
     * @return a Set<Square> of the possible squares this rook can move to. Returns an empty set
     * if there are no legal moves.
     */
    @Override
    public Set<Square> possibleMoves(Square start, ChessBoard board) {
        Set<Square> possibleMoves = new HashSet<>();
        possibleMoves.addAll(checkMovesInDirection(start, board,1,1));
        possibleMoves.addAll(checkMovesInDirection(start, board,1,-1));
        possibleMoves.addAll(checkMovesInDirection(start, board,-1,1));
        possibleMoves.addAll(checkMovesInDirection(start, board,-1,-1));
        possibleMoves.addAll(checkMovesInDirection(start, board, 0, 1));
        possibleMoves.addAll(checkMovesInDirection(start, board, 0, -1));
        possibleMoves.addAll(checkMovesInDirection(start, board, 1, 0));
        possibleMoves.addAll(checkMovesInDirection(start, board, -1, 0));
        return possibleMoves;
    }

    /**
     * Calculates all of the possible captures this Queen can legally perform.
     *
     * @param start the square from which the Queen starts.
     * @param board the chess board that this Queen is on.
     * @return a set of squares on which lie the capturable pieces. Returns an empty set if there are none.
     */
    @Override
    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        Set<Square> possibleCaptures = new HashSet<>();
        checkCaptureInDirection(start, board,1,1,possibleCaptures);
        checkCaptureInDirection(start, board,1,-1,possibleCaptures);
        checkCaptureInDirection(start, board,-1,1,possibleCaptures);
        checkCaptureInDirection(start, board,-1,-1,possibleCaptures);
        checkCaptureInDirection(start, board, 1, 0, possibleCaptures);
        checkCaptureInDirection(start, board, -1, 0, possibleCaptures);
        checkCaptureInDirection(start, board, 0, 1, possibleCaptures);
        checkCaptureInDirection(start, board, 0, -1, possibleCaptures);
        return possibleCaptures;
    }

    /**
     * Returns a String representation of this Queen.
     *
     * @return 'q' for a white Queen, 'Q' for a black Queen.
     */
    public String toString() {
        if(super.getColor() == 'w') {
            return "q";
        } else {
            return "Q";
        }
    }
}

package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.HashSet;
import java.util.Set;

/**
 * Defines a chess Bishop object.
 */
public class Bishop extends ChessPiece {
    /**
     * Creates a new Bishop instance with the given color.
     * @param color 'w' for a white Bishop, 'b' for a black Bishop.
     */
    public Bishop(char color) {
        super(color);
    }

    /**
     * Calculates all of the possible moves this Bishop can legally make.
     *
     * @param start the Square this Bishop is on.
     * @param board the ChessBoard this Bishop is in.
     * @return a Set<Square> of the possible squares this Bishop can move to. Returns an empty set
     * if there are no legal moves.
     */
    @Override
    public Set<Square> possibleMoves(Square start, ChessBoard board) {
        Set<Square> possibleMoves = new HashSet<>();
        possibleMoves.addAll(checkMovesInDirection(start, board,1,1));
        possibleMoves.addAll(checkMovesInDirection(start, board,1,-1));
        possibleMoves.addAll(checkMovesInDirection(start, board,-1,1));
        possibleMoves.addAll(checkMovesInDirection(start, board,-1,-1));
        return possibleMoves;
    }

    /**
     * Calculates all of the possible captures this Bishop can legally perform.
     *
     * @param start the square from which the Bishop starts.
     * @param board the chess board that this Bishop is on.
     * @return a set of squares on which lie the capturable pieces. Returns an empty set if there are none.
     */
    @Override
    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        Set<Square> possibleCaptures = new HashSet<>();
        checkCaptureInDirection(start, board,1,1,possibleCaptures);
        checkCaptureInDirection(start, board,1,-1,possibleCaptures);
        checkCaptureInDirection(start, board,-1,1,possibleCaptures);
        checkCaptureInDirection(start, board,-1,-1,possibleCaptures);
        return possibleCaptures;
    }


    /**
     * Returns a String representation of this Bishop
     *
     * @return 'b' for a white Bishop, 'B' for a black bishop.
     */
    public String toString() {
        if(super.getColor() == 'w') {
            return "b";
        } else {
            return "B";
        }
    }
}

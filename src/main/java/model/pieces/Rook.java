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
     * Checks the possible moves in the given direction.
     *
     * @param start the Square this Rook is on.
     * @param board the ChessBoard this Rook is in.
     * @param fileChange used to define the direction. 1 for up, -1 for down, 0 if moving along rank.
     * @param rankChange used to define the direction. 1 for right, -1 for left, 0 if moving along file.
     * @return the set of squares that the rook can move to in the given direction.
     */
    private Set<Square> checkMovesInDirection(Square start, ChessBoard board, int fileChange, int rankChange){
        Set<Square> subSetMoves = new HashSet<>();
        Square toCheck = board.getSquare(start.getFile() + fileChange, start.getRank() + rankChange);
        while(toCheck != null && !toCheck.isOccupied()){
            subSetMoves.add(toCheck);
            toCheck = board.getSquare(toCheck.getFile() + fileChange, toCheck.getRank() + rankChange);
        }
        return subSetMoves;
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
     * Checks for a capturable piece in the given direction.
     *
     * @param start the square from which the Rook starts.
     * @param board the chess board this rook is on.
     * @param fileChange used to define the direction. 1 for up, -1 for down, 0 if moving along rank.
     * @param rankChange used to define the direction. 1 for right, -1 for left, 0 if moving along file.
     * @param possibleCaptures the set to which the square of a capturable piece should be added.
     */
    private void checkCaptureInDirection(Square start, ChessBoard board, int fileChange, int rankChange, Set<Square> possibleCaptures){
        Square toCheck = board.getSquare(start.getFile() + fileChange, start.getRank() + rankChange);
        while(toCheck != null && !toCheck.isOccupied()){
            toCheck = board.getSquare(toCheck.getFile() + fileChange, toCheck.getRank() + rankChange);
        }
        if(toCheck != null && toCheck.isEnemyOccupied(super.getColor())){
            possibleCaptures.add(toCheck);
        }
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

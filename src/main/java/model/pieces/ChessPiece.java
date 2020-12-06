package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an abstract ChessPiece object. All specialized chess pieces inherit
 * from this class.
 */
public abstract class ChessPiece {

    // The color of this piece. 'w' for white pieces, 'b' for black pieces.
    private final char color;

    // Whether this piece has moved. True if moved, false if not.
    private boolean hasMoved;

    /**
     * Creates a ChessPiece with the given color char.
     *
     * @throws IllegalArgumentException if color is not 'w' or 'b'.
     * @param color 'w' for white pieces, 'b' for black pieces.
     */
    public ChessPiece(char color) {
        if(color != 'w' && color != 'b'){
            throw new IllegalArgumentException("Color must be 'w' or 'b'");
        } else {
            this.color = color;
        }
    }

    /**
     * Calculates all of the possible moves this Piece can make with the given starting
     * position and state of the chess board.
     *
     * @param start the Square this Piece is on.
     * @param board the ChessBoard this Piece is in.
     * @return a Set<Square> of the possible moves this Piece can make.
     */
    public abstract Set<Square> possibleMoves(Square start, ChessBoard board);

    /**
     * Checks the possible moves in the given direction.
     *
     * @param start the Square this Piece is on.
     * @param board the ChessBoard this Piece is in.
     * @param fileChange used to define the direction. 1 for up, -1 for down, 0 if moving along rank.
     * @param rankChange used to define the direction. 1 for right, -1 for left, 0 if moving along file.
     * @return the set of squares that the rook can move to in the given direction.
     */
    protected Set<Square> checkMovesInDirection(Square start, ChessBoard board, int fileChange, int rankChange){
        Set<Square> subSetMoves = new HashSet<>();
        Square toCheck = board.getSquare(start.getFile() + fileChange, start.getRank() + rankChange);
        while(toCheck != null && !toCheck.isOccupied()){
            subSetMoves.add(toCheck);
            toCheck = board.getSquare(toCheck.getFile() + fileChange, toCheck.getRank() + rankChange);
        }
        return subSetMoves;
    }

    /**
     * Calculates all of the pieces this piece can capture.
     *
     * @param start the square from which the piece starts.
     * @param board the chess board that this piece is on.
     * @return a Set<Square> that contains all of the capturable enemy pieces.
     */
    public abstract Set<Square> possibleCaptures(Square start, ChessBoard board);

    /**
     * Checks for a capturable piece in the given direction.
     *
     * @param start the square from which this Piece starts.
     * @param board the chess board this Piece is on.
     * @param fileChange used to define the direction. 1 for up, -1 for down, 0 if moving along rank.
     * @param rankChange used to define the direction. 1 for right, -1 for left, 0 if moving along file.
     * @param possibleCaptures the set to which the square of a capturable piece should be added.
     */
    protected void checkCaptureInDirection(Square start, ChessBoard board, int fileChange, int rankChange, Set<Square> possibleCaptures){
        Square toCheck = board.getSquare(start.getFile() + fileChange, start.getRank() + rankChange);
        while(toCheck != null && !toCheck.isOccupied()){
            toCheck = board.getSquare(toCheck.getFile() + fileChange, toCheck.getRank() + rankChange);
        }
        if(toCheck != null && toCheck.isEnemyOccupied(color)){
            possibleCaptures.add(toCheck);
        }
    }

    /**
     * Returns if this piece has moved this game.
     * @return true if the piece has moved, false otherwise.
     */
    public boolean hasMoved() {
        return hasMoved;
    }

    /**
     * Used to ensure the functionality of hasMoved(). Call when this piece is moved.
     */
    public void moved(){
        hasMoved = true;
    }

    /**
     * Returns the color of this piece.
     * @return 'w' if the piece is white, 'b' if the piece is black.
     */
    public char getColor() {
        return color;
    }

}

package model.pieces;

import model.ChessBoard;
import model.Square;
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
     * Calculates all of the pieces this piece can capture.
     *
     * @param start the square from which the piece starts.
     * @param board the chess board that this piece is on.
     * @return a Set<Square> that contains all of the capturable enemy pieces.
     */
    public abstract Set<Square> possibleCaptures(Square start, ChessBoard board);

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

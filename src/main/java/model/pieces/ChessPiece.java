package model.pieces;

import model.Square;

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
     * Determines whether this piece can make the given move.
     *
     * @param start the square from which the piece starts.
     * @param finish the square that the piece is moving to.
     * @return true if the piece can make the given move legally, false otherwise.
     */
    public abstract boolean canMoveTo(Square start, Square finish);

    /**
     * Determines whether this piece can perform the given capture.
     *
     * @param start the square from which the piece starts.
     * @param enemy the square where the enemy piece resides.
     * @return true if the capture can be performed legally, false otherwise.
     */
    public abstract boolean canCapture(Square start, Square enemy);

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

    public abstract void moveTo(Square square);

}

package model.pieces;

import model.Square;

/**
 * Represents a chess Pawn.
 */
public class Pawn extends ChessPiece {

    /**
     * Creates a Pawn with the given color char.
     *
     * @throws IllegalArgumentException if color is not 'w' or 'b'.
     * @param color 'w' for white pieces, 'b' for black pieces.
     */
    public Pawn(char color) {
        super(color);
    }

    /**
     * Determines whether this Pawn can make the given move.
     *
     * @param start the square from which the Pawn starts.
     * @param finish the square that the Pawn is moving to.
     * @return true if the Pawn can make the given move legally, false otherwise.
     */
    public boolean canMoveTo(Square start, Square finish) {
        if(finish.isOccupied()) {
            return false;
        } else if(finish.getRank() == start.getRank() + move(1)) {
            return true;
        } else if(!super.hasMoved() && finish.getRank() == start.getRank() + move(2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Used to generalize expressions for white and black pieces
     *
     * @param numSquares the number of squares being moved
     * @return positive numSquares if white, negative numSquares if black.
     */
    private int move(int numSquares) {
        if(super.getColor() == 'w'){
            return numSquares;
        } else {
            return -numSquares;
        }
    }

    /**
     * Determines whether this Pawn can make the given capture.
     *
     * @param start the square from which this Pawn starts.
     * @param enemy the square where the enemy piece resides.
     * @return true if the capture is legal, false if illegal.
     */
    public boolean canCapture(Square start, Square enemy) {
        if(!enemy.isOccupied()){
            return canEnPassant(start, enemy);
        } else {
            return enemy.getRank() == start.getRank() + move(1) && Math.abs(start.getFile() - enemy.getFile()) == 1;
        }
    }

    /**
     * Determines whether this Pawn can make an En Passant capture.
     *
     * @param start the square from which this Pawn starts.
     * @param enemy the square behind the enemy piece resides.
     * @return true if the En Passant capture is legal, false if illegal.
     */
    private boolean canEnPassant(Square start, Square enemy) {
        throw new UnsupportedOperationException();
    }

    public void moveTo(Square square) {

    }

    /**
     * Returns a String representation of this Pawn.
     * @return "p" if this Pawn is white, "P" if this Pawn is black.
     */
    public String toString() {
        if(super.getColor() == 'w') {
            return "p";
        } else {
            return "P";
        }
    }
}

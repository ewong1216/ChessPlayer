package model;

import model.pieces.ChessPiece;

/**
 * Defines a single Square object on a ChessBoard, which can be empty or occupied by a ChessPiece.
 */
public class Square {

    /**
     * The file and rank where this Square is located.
     * file 0-7 corresponds to a real life ChessBoard A-H.
     * rank 0-7 corresponds to a real life ChessBoard 1-8.
     */
    private ChessCoordinate location;

    /**
     * The ChessPiece that is located on this Square.
     * null if no piece is on this Square.
     */
    private ChessPiece piece;


    /**
     * Creates a new Square object with the given piece located on it.
     * e.g. the Square C5 has file 2 and rank 4.
     *
     * @param location the ChessCoordinate of this Square.
     * @param piece the piece located on this Square.
     */
    public Square(ChessCoordinate location, ChessPiece piece) {
        this.location = location;
        this.piece = piece;
    }

    /**
     * Returns a reference to the ChessPiece located on this Square.
     *
     * @return the ChessPiece located on this Square, null if no piece on this square.
     */
    public ChessPiece getPiece() {
        return piece;
    }

    public ChessCoordinate getCoordinate(){
        return location;
    }
    /**
     * Used to set the ChessPiece field for the sole purpose of ChessBoard.isSquareAttacked.
     *
     * @param piece the temporary piece to allow Pawns to detect a capture.
     */
    public void setPiece(ChessPiece piece){
        this.piece = piece;
    }

    /**
     * Removes the ChessPiece from this Square.
     */
    public void clear(){
        piece = null;
    }

    /**
     * Returns whether this Square is occupied or not.
     * @return true if occupied, false if not.
     */
    public boolean isOccupied() {
        return piece != null;
    }

    /**
     * Determines if this Square is occupied by a piece of opposite color of the given color.
     * @param color the color to compare to this Square's Piece's color.
     * @return true if the colors are opposite, false if they are the same.
     */
    public boolean isEnemyOccupied(char color){
        return isOccupied() && piece.getColor() != color;
    }

    /**
     * Returns the file of this Square.
     * 0-7 corresponds with the A-H files on a ChessBoard.
     * @return a file between [0,7]
     */
    public int getFile(){
        return location.getFile();
    }

    /**
     * Returns the rank of this Square.
     * 0-7 corresponds with the 1-8 ranks on a ChessBoard.
     * @return a rank between [0,7]
     */
    public int getRank(){
        return location.getRank();
    }

    /**
     * String representation of this Square to be printed.
     *
     * @return a space if the Square is empty, otherwise returns the string representation of the
     * piece located on this Square.
     */
    public String toString(){
        if(isOccupied()) {
            return piece.toString();
        } else {
            return " ";
        }
    }

    /**
     * Determines if this Square and the other Object are equal.
     * @param other the Object to compare to.
     * @return true if other is a Square object and the two Squares have the same file and rank.
     */
    public boolean equals(Object other){
        if(this == other){
            return true;
        } else if(other.getClass() != Square.class){
            return false;
        } else {
            Square otherSquare = (Square) other;
            return location.equals(otherSquare.location);
        }
    }
}

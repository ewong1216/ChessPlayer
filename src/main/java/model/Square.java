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
    private final int file;
    private final int rank;

    /**
     * The ChessPiece that is located on this Square.
     * null if no piece is on this Square.
     */
    private ChessPiece piece;

    /**
     * Creates a new Square object with no piece on it.
     * e.g. the Square C5 has file 2 and rank 4.
     *
     * @param file the file of the Square as an integer.
     * @param rank the rank of the Square - 1.
     */
    public Square(int file, int rank) {
        this(file, rank, null);
    }

    /**
     * Creates a new Square object with the given piece located on it.
     * e.g. the Square C5 has file 2 and rank 4.
     *
     * @param file the file of the Square as an integer.
     * @param rank the rank of the Square - 1.
     * @param piece the piece located on this Square.
     */
    public Square(int file, int rank, ChessPiece piece) {
        this.file = file;
        this.rank = rank;
        this.piece = piece;
    }

    /**
     * Returns a reference to the ChessPiece located on this Square.
     *
     * @return the ChessPiece located on this Square.
     */
    public ChessPiece getPiece() {
        return piece;
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
     * Returns the file of this Square.
     * 0-7 corresponds with the A-H files on a ChessBoard.
     * @return a file between [0,7]
     */
    public int getFile(){
        return file;
    }

    /**
     * Returns the rank of this Square.
     * 0-7 corresponds with the 1-8 ranks on a ChessBoard.
     * @return a rank between [0,7]
     */
    public int getRank(){
        return rank;
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

}

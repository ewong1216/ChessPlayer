package model;

import model.pieces.ChessPiece;

public class Square {
    private int file;
    private int rank;

    private ChessPiece piece;

    public Square(int file, int rank) {
        this(file, rank, null);
    }

    public Square(int file, int rank, ChessPiece piece) {
        this.file = file;
        this.rank = rank;
        this.piece = piece;
    }

    public ChessPiece piece() {
        return piece;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public String toString(){
        if(isOccupied()) {
            return piece.toString();
        } else {
            return " ";
        }
    }

}

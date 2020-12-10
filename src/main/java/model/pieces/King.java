package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Defines a chess King object.
 */
public class King extends ChessPiece {
    /**
     * Creates a new King instance with the given color.
     * @param color 'w' for a white King, 'b' for a black King.
     */
    public King(char color) {
        super(color);
    }

    /**
     * Calculates all of the possible moves this King can legally make.
     *
     * @param start the Square this King is on.
     * @param board the ChessBoard this King is in.
     * @return a Set<Square> of the possible squares this King can move to. Returns an empty set
     * if there are no legal moves.
     */
    @Override
    public Set<Square> possibleMoves(Square start, ChessBoard board) {
        Set<Square> possibleMoves = adjacentSquares(start, board);
        Iterator<Square> iterator = possibleMoves.iterator();
        while(iterator.hasNext()){
            Square toCheck = iterator.next();
            if(toCheck.getPiece() != null){
                iterator.remove();
            }
        }
        return possibleMoves;
    }

    /**
     * Finds and returns the set of squares adjacent to the King.
     *
     * @param start the Square this King is on.
     * @param board the ChessBoard this King is on.
     * @return a set of Squares adjacent to this King.
     */
    private Set<Square> adjacentSquares(Square start, ChessBoard board){
        Set<Square> adjacent = new HashSet<>();
        for(int fileChange = -1; fileChange <= 1; fileChange++){
            for(int rankChange = -1; rankChange <= 1; rankChange++){
                if(fileChange != 0 || rankChange != 0) {
                    Square toCheck = board.getSquare(start.getFile() + fileChange, start.getRank() + rankChange);
                    if (toCheck != null) {
                        adjacent.add(toCheck);
                    }
                }
            }
        }
        return adjacent;
    }

    /**
     * Calculates all of the possible captures this King can legally perform.
     * @param start the square from which the piece starts.
     * @param board the chess board that this piece is on.
     * @return a set of squares on which lie the capturable pieces. Returns an empty set if there are none.
     */
    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        Set<Square> possibleCaptures = adjacentSquares(start, board);
        Iterator<Square> iterator = possibleCaptures.iterator();
        while(iterator.hasNext()){
            Square toCheck = iterator.next();
            if(toCheck.getPiece() == null){
                iterator.remove(); // If no piece on the square, no capture.
            } else {
                ChessPiece temp = toCheck.getPiece();
                if(temp.getColor() == super.getColor()){
                    iterator.remove(); // If the piece is the same color, no capture.
                }
            }
        }
        return possibleCaptures;
    }

    public String toString() {
        if(super.getColor() == 'w') {
            return "k";
        } else {
            return "K";
        }
    }
}

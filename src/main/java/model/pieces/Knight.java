package model.pieces;

import model.ChessBoard;
import model.Square;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Defines a chess Knight Piece
 */


public class Knight extends ChessPiece {

    /**
     * Creates a new color Knight with the given color
     * @param color the color of the Knight
     */

    public Knight(char color) {
        super(color);
    }

    /**
     * Finds and returns the set of squares the Knight can jump to.
     *
     * @param start the Square this Knight is on.
     * @param board the ChessBoard this Knight is on.
     * @return a set of Squares the Knight can jump to.
     */
    private Set<Square> viableSquares(Square start, ChessBoard board){
        Set<Square> viable = new HashSet<>();
        for(int fileChange = -2; fileChange <= 2; fileChange++){
            for(int rankChange = -2; rankChange <= 2; rankChange++){
                int absChangeX= Math.abs(fileChange);
                int absChangeY= Math.abs(rankChange);
                if((absChangeX + absChangeY) == 3 && fileChange != 0 && rankChange != 0) {
                    Square toCheck = board.getSquare(start.getFile() + fileChange, start.getRank() + rankChange);
                    if (toCheck != null) {
                        viable.add(toCheck);
                    }
                }
            }
        }
        return viable;
    }



    /**
     * Calculates all of the possible moves this Knight can legally make.
     * @param start the Square this Knight is on.
     * @param board the ChessBoard this Knight is in.
     * @return a Set<Square> of the possible squares this Knight can move to. Returns an empty set
     * if there are no legal moves.
     */
    public Set<Square> possibleMoves(Square start, ChessBoard board) {
        Set<Square> possibleMoves = viableSquares(start, board);
        possibleMoves.removeIf(toCheck -> toCheck.getPiece() != null);
        return possibleMoves;
    }

    /**
     * Calculates all of the possible captures this Knight can legally make.
     *
     * @param start the Square this Knight is on.
     * @param board the ChessBoard this Knight is in.
     * @return a set of squares on which lie the capturable pieces. Returns empty set if there are none.
     */

    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        Set<Square> possibleCaptures = viableSquares(start, board);
        Iterator<Square> iterator = possibleCaptures.iterator();
        while(iterator.hasNext()){
            Square toCheck = iterator.next();
            if(toCheck.getPiece() == null){
                iterator.remove(); // If theres no piece on the square, there is no capture.
            } else {
                ChessPiece temp = toCheck.getPiece();
                if(temp.getColor() == super.getColor()){
                    iterator.remove(); // If the piece is the same color, there is no capture.
                }
            }
        }
        return possibleCaptures;

    }

    /**
     * Returns a String representation of this Knight
     * @return "K" if a black rook, "k" if a white rook.
     */

    public String toString() {
        if(super.getColor() == 'w') {
            return "k";
        } else {
            return "K";
        }
    }
}

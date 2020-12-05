package model.pieces;

import model.ChessBoard;
import model.Square;
import java.util.Set;
import java.util.HashSet;

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
     * Determines all of the possible moves this Pawn can make.
     *
     * @param start the Square this Pawn is on.
     * @param board the ChessBoard this Pawn in in.
     * @return a Set<Square> containing all of the possible moves.
     */
    public Set<Square> possibleMoves(Square start, ChessBoard board){
        HashSet<Square> possibleMoves = new HashSet<>();
        Square oneForward = board.getSquare(start.getFile(), start.getRank() + move(1));
        Square twoForward = board.getSquare(start.getFile(), start.getRank() + move(2));
        if(!oneForward.isOccupied()){
            possibleMoves.add(oneForward);
        }
        if(twoForward != null && !super.hasMoved() && !twoForward.isOccupied()){
            possibleMoves.add(twoForward);
        }
        return possibleMoves;
    }

    /**
     * Used to generalize expressions for white and black Pawns since white pawns only
     * move up and black pawns only move down.
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
     * Calculates all of the possible captures this Pawn can make.
     *
     * @param start the square from which this Pawn starts.
     * @param board the chess board this Pawn is in.
     * @return a Set<Square> of the possible captures this Pawn can make.
     */
    public Set<Square> possibleCaptures(Square start, ChessBoard board) {
        Set<Square> possibleCaptures = new HashSet<>();
        Square leftDiagonal = board.getSquare(start.getFile() - 1, start.getRank() + move(1));
        Square rightDiagonal = board.getSquare(start.getFile() + 1, start.getRank() + move(1));
        if(leftDiagonal != null && leftDiagonal.isEnemyOccupied(super.getColor())){
            possibleCaptures.add(leftDiagonal);
        }
        if(rightDiagonal != null && rightDiagonal.isEnemyOccupied(super.getColor())){
            possibleCaptures.add((rightDiagonal));
        }

        Square movedLast = board.getMovedLast();
        int fileDistance = enPassantFileDistance(start, movedLast);
        if(movedLast.getPiece().getClass() == Pawn.class && movedLast.isEnemyOccupied(super.getColor()) && Math.abs(fileDistance) == 1){
            if(fileDistance == 1){
                possibleCaptures.add(rightDiagonal);
            } else if(fileDistance == -1){
                possibleCaptures.add(leftDiagonal);
            }
        }
        return possibleCaptures;
    }

//    /**
//     * Determines whether this Pawn can make an En Passant capture.
//     * TODO
//     * @return true if the En Passant capture is legal, false if illegal.
//     */
//    private boolean enPassantRank(Square start, Square movedLast) {
//        return enPassantFileDistance(start, movedLast) != 0;
//    }

    /**
     * Used to determine whether this Pawn can perform an En Passant capture.
     * @param start the square this Pawn is on.
     * @param movedLast the square of the piece that moved most recently.
     * @return If the two pieces are on the same rank, and that rank matches the
     * rank on which this Pawn can en passant, returns the difference of their files. Returns 0 otherwise.
     */
    private int enPassantFileDistance(Square start, Square movedLast){
        if(super.getColor() == 'w'){
            if(start.getRank() == 4 && movedLast.getRank() == 4){
                return movedLast.getFile() - start.getFile();
            }
        } else if(start.getRank() == 3 && movedLast.getRank() == 3){
            return movedLast.getFile() - start.getFile();
        }
        return 0;
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

package model;

import model.pieces.ChessPiece;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is capable of creating and managing a Chess Game.
 * It takes in moves as two ChessCoordinates, and makes that move.
 * Once the game is over, moves will be impossible.
 */
public class ChessGame {

    private final ChessBoard board;
    private final List<Move> moveList;
    private char turn;

    /**
     * Instantiates a new ChessGame with the given board.
     *
     * @param board any non-null ChessBoard.
     */
    public ChessGame(ChessBoard board) {
        this.board = board;
        this.moveList = new ArrayList<>();
        this.turn = 'w';
    }

    /**
     * This public method attempts to make the move that moves the piece
     * on the 'startCoordinate' to the 'endCoordinate.' If the game is
     * over, the 'startCoordinate' equals the 'endCoordinate', it is not
     * the pieces turn to move or the move is illegal the move will fail.
     * This method returns true if the move is successful, false otherwise.
     *
     * @param startCoordinate the coordinate of the starting location
     * @param endCoordinate the coordinate of the ending location
     * @return whether or not the move was successful.
     */
    public boolean makeMove(ChessCoordinate startCoordinate, ChessCoordinate endCoordinate) {
        boolean didMove = false;
        if (!startCoordinate.equals(endCoordinate)) {
            ChessPiece piece = board.getPieceOnSquare(startCoordinate);
            if (piece != null && piece.getColor() == turn) {
                Move lastMove = board.makeMove(
                        board.getSquare(startCoordinate.getFile(), startCoordinate.getRank()),
                        board.getSquare(endCoordinate.getFile(), endCoordinate.getRank()));
                if (lastMove != null) {
                    didMove = true;
                    turn = (turn == 'w') ? 'b' : 'w';
                    moveList.add(lastMove);
                }
            }
        }
        return didMove;
    }

    /**
     * @return the previous move.
     */
    public Move getLastMove() {
        Move move;
        if (moveList.isEmpty()) {
            move = null;
        } else {
            move = moveList.get(moveList.size() - 1);
        }
        return move;
    }

    /**
     * @return the board.
     */
    public ChessBoard getBoard() {
        return board;
    }
}

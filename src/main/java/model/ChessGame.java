package model;

import model.pieces.ChessPiece;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {

    private final ChessBoard board;
    private final List<Move> moveList;

    public ChessGame(ChessBoard board) {
        this.board = board;
        this.moveList = new ArrayList<>();
    }

    public ChessBoard getBoard() {
        return board;
    }

    public boolean makeMove(ChessCoordinate startCoordinate, ChessCoordinate endCoordinate) {
        boolean didMove = false;
        if (!startCoordinate.equals(endCoordinate)) {
            ChessPiece piece = board.getPieceOnSquare(startCoordinate);
            if (piece != null) {
                didMove = board.makeMove("");
            }
        }
        return didMove;
    }

    public Move getLastMove() {
        Move move;
        if (moveList.isEmpty()) {
            move = null;
        } else {
            move = moveList.get(moveList.size() - 1);
        }
        return move;
    }
}

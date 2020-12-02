package model;

public class ChessGame {

    private final ChessBoard board;

    public ChessGame(ChessBoard board) {
        this.board = board;
    }

    public ChessBoard getBoard() {
        return board;
    }
}

package controller;

import model.ChessBoard;
import model.ChessBoardFactory;

public class ChessController {

    private final ChessBoard board;

    public static void main(String[] args) {
        new ChessController();
    }

    private ChessController() {
        board = ChessBoardFactory.createNormalBoard();
        System.out.println(board.toString());
    }
}

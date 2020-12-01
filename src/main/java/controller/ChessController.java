package controller;

import model.ChessBoard;

public class ChessController {

    public static void main(String[] args) {
        new ChessController();
    }

    private ChessController() {
        ChessBoard board = new ChessBoard();
        System.out.println(board.toString());
    }
}

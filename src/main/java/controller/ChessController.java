package controller;

import model.ChessBoard;
import model.ChessBoardFactory;
import model.ChessGame;

public class ChessController {

    private final ChessGame game;

    public static void main(String[] args) {
        new ChessController();
    }

    private ChessController() {
        game = new ChessGame(ChessBoardFactory.createNormalBoard());
        System.out.println(game.getBoard().toString());
    }
}

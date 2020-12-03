package controller;

import model.ChessBoardFactory;
import model.ChessGame;
import view.ChessView;

public class ChessController {

    private final ChessGame game;

    public static void main(String[] args) {
        new ChessController();
    }

    private ChessController() {
        game = new ChessGame(ChessBoardFactory.createNormalBoard());
        ChessView chessView = new ChessView(game.getBoard().getBoard());
        System.out.println(game.getBoard().toString());
    }
}

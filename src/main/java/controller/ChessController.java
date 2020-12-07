package controller;

import model.ChessBoardFactory;
import model.ChessCoordinate;
import model.ChessGame;
import view.ChessPieceView;
import view.ChessView;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class is capable of controlling a ChessGame And ChessView
 * to play chess.
 */
public class ChessController implements MouseMotionListener, MouseListener {

    private final ChessGame game;
    private final ChessView chessView;

    private ChessCoordinate startCoordinate;
    private int xOnSquare = 0;
    private int yOnSquare = 0;

    public static void main(String[] args) {
        new ChessController();
    }

    /**
     * Creates a new ChessController and creates a normal chess game
     * with a normal board.
     */
    private ChessController() {
        game = new ChessGame(ChessBoardFactory.createNormalBoard());
        chessView = new ChessView(game.getBoard().getBoard(), this, this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        e.getComponent().setLocation(e.getX() - xOnSquare + e.getComponent().getX(),
                e.getY() - yOnSquare + e.getComponent().getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Component component = e.getComponent();
        if (component instanceof ChessPieceView && ((ChessPieceView) component).isOnBoard()) {
            xOnSquare = e.getX();
            yOnSquare = e.getY();
            startCoordinate = chessView.getCoordinateOf(component, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(chessView.getCoordinateOf(e.getComponent(), e.getX(), e.getY()));
        ChessCoordinate endCoordinate = chessView.getCoordinateOf(e.getComponent(),
                e.getX(), e.getY());

        game.makeMove(startCoordinate, endCoordinate);

        chessView.updateScreen(game.getLastMove());
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}

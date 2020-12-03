package controller;

import model.ChessBoardFactory;
import model.ChessGame;
import view.ChessView;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ChessController implements MouseMotionListener, MouseListener {

    private final ChessGame game;
    private final ChessView chessView;

    private int xOnSquare = 0;
    private int yOnSquare = 0;

    public static void main(String[] args) {
        new ChessController();
    }

    private ChessController() {
        game = new ChessGame(ChessBoardFactory.createNormalBoard());
        chessView = new ChessView(game.getBoard().getBoard(), this, this);
        System.out.println(game.getBoard().toString());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    private static int getYOnWindow(Component component) {
        if (component instanceof ChessView) {
            return 0;
        } else {
            return getYOnWindow(component.getParent()) + component.getY();
        }
    }

    private static int getXOnWindow(Component component) {
        if (component instanceof ChessView) {
            return 0;
        } else {
            return getXOnWindow(component.getParent()) + component.getX();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        e.getComponent().setLocation(e.getX() - xOnSquare + e.getComponent().getX(),
                e.getY() - yOnSquare + e.getComponent().getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xOnSquare = e.getX();
        yOnSquare = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //TODO: Add movement code
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}

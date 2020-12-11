package view;

import model.ChessBoard;
import model.ChessCoordinate;
import model.Move;
import model.Square;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * This Class is capable of displaying a Chess Game in a
 * JFrame window.
 */
public class ChessView extends JFrame {

    // The starting size of the screen (Can be adjusted after creation)
    private static final int STARTING_SIZE = 500;

    private final ChessBoardView boardView;
    private final ChessTurnView turnView;

    /**
     * Creates a new ChessView that displays the given board. The
     * Displayed pieces will use the given MouseListener and MouseMotionListener
     * to drag the pieces.
     *
     * @param board the board to display.
     * @param mouseListener the MouseListener for the PieceViews to use.
     * @param motionListener the MouseMotionListener for the PieceViews to use.
     */
    public ChessView(Square[][] board, MouseListener mouseListener,
                     MouseMotionListener motionListener) {
        boardView = new ChessBoardView(board, mouseListener, motionListener);
        turnView = new ChessTurnView('w');
        init();
        this.add(boardView, BorderLayout.CENTER);
        this.add(turnView, BorderLayout.SOUTH);
    }

    /**
     * Initializes this JFrame.
     */
    private void init() {
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setPreferredSize(new Dimension(STARTING_SIZE, STARTING_SIZE));
        pack();
    }

    public void updateScreen(Move move) {
        if (move != null) {
            boardView.updateBoard(move);
            turnView.switchTurns();
        }
        this.pack();
    }

    public ChessCoordinate getCoordinateOf(Component component, int mouseX, int mouseY) {
        int squareWidth = boardView.getWidth() / 8;
        int squareHeight = boardView.getHeight() / 8;
        int xCoordinate = (getXOnWindow(component) + mouseX) / (squareWidth);
        int yCoordinate = 7 - (getYOnWindow(component) + mouseY) / squareHeight;
        return new ChessCoordinate(xCoordinate, yCoordinate);
    }

    private static int getYOnWindow(Component component) {
        if (component instanceof ChessBoardView) {
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

}

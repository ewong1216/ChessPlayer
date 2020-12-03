package view;

import model.Square;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ChessView extends JFrame {

    private static final int STARTING_SIZE = 500;

    private final ChessBoardView boardView;

    public ChessView(Square[][] board, MouseListener mouseListener,
                     MouseMotionListener motionListener) {
        boardView = new ChessBoardView(board, mouseListener, motionListener);
        init();
        this.add(boardView, BorderLayout.CENTER);
    }

    private void init() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setPreferredSize(new Dimension(STARTING_SIZE, STARTING_SIZE));
        this.pack();
    }
}

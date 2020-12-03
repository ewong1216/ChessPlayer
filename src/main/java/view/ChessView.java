package view;

import model.ChessBoard;
import model.Square;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class ChessView extends JFrame {

    private final ChessBoardView boardView;

    public ChessView(Square[][] board) {
        boardView = new ChessBoardView(board);
        init();
        this.add(boardView, BorderLayout.CENTER);
    }

    private void init() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setPreferredSize(new Dimension(500, 500));
        this.pack();
    }
}

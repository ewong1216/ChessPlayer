package view;

import model.Square;

import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ChessBoardView extends JPanel {

    private final JPanel squaresPanel;
    private final JPanel piecesPanel;

    public ChessBoardView(Square[][] board, MouseListener mouseListener,
                          MouseMotionListener motionListener) {
        this.setLayout(new OverlayLayout(this));
        squaresPanel = new JPanel(new GridLayout(8, 8));
        piecesPanel = new JPanel(new GridLayout(8, 8));
        initBoardView(board, mouseListener, motionListener);
    }

    private void initBoardView(Square[][] board, MouseListener mouseListener,
                               MouseMotionListener motionListener) {
        piecesPanel.setOpaque(false);
        for (int rank = 7; rank >= 0; rank--) {
            for (int file = 0; file < 8; file++) {
                Color squareColor = (rank + file) % 2 == 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY;
                ChessPieceView pieceView = new ChessPieceView(board[file][rank].getPiece());
                pieceView.addMouseListener(mouseListener);
                pieceView.addMouseMotionListener(motionListener);
                piecesPanel.add(pieceView);
                squaresPanel.add(new ChessSquareView(squareColor));
            }
        }
        this.add(piecesPanel);
        this.add(squaresPanel);
    }
}

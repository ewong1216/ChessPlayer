package view;

import model.Square;
import model.pieces.ChessPiece;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class ChessBoardView extends JPanel {

    public ChessBoardView(Square[][] board) {
        this.setSize(300, 300);
        this.setLayout(new GridLayout(8, 8));
        initBoardView(board);
    }

    private void initBoardView(Square[][] board) {
        for (int rank = 7; rank >= 0; rank--) {
            for (int file = 0; file < 8; file++) {
                Color squareColor = (rank + file) % 2 == 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY;
                ChessPiece piece = board[file][rank].getPiece();
                this.add(new ChessSquareView(squareColor, new ChessPieceView(piece)));
            }
        }
    }
}

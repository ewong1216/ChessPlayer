package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class ChessSquareView extends JPanel {

    public ChessSquareView(Color backgroundColor, ChessPieceView pieceView) {
        this.setLayout(new BorderLayout());
        this.setBackground(backgroundColor);
        this.add(pieceView, BorderLayout.CENTER);
    }

    public ChessSquareView(Color backgroundColor) {
        this(backgroundColor, null);
    }
}

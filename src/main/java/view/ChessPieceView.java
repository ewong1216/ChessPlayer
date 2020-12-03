package view;

import model.pieces.Bishop;
import model.pieces.ChessPiece;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Queen;
import model.pieces.Rook;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ChessPieceView extends JLabel {

    public ChessPieceView(ChessPiece piece) {
        super(getImage(piece));
    }

    private static ImageIcon getImage(ChessPiece piece) {
        String path = "images/";

        if (piece instanceof Pawn) {
            path += (piece.getColor() == 'w') ? "WPawn.png" : "BPawn.png";
        } else if (piece instanceof Rook) {
            path += (piece.getColor() == 'w') ? "WRook.png" : "BRook.png";
        } else if (piece instanceof Knight) {
            path += (piece.getColor() == 'w') ? "WKnight.png" : "BKnight.png";
        } else if (piece instanceof Bishop) {
            path += (piece.getColor() == 'w') ? "WBishop.png" : "BBishop.png";
        } else if (piece instanceof Queen) {
            path += (piece.getColor() == 'w') ? "WQueen.png" : "BQueen.png";
        } else if (piece instanceof King) {
            path += (piece.getColor() == 'w') ? "WKing.png" : "BKing.png";
        }

        return new ImageIcon(path);
    }

}

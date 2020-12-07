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

/**
 * This class is capable of making a JLabel that displays a
 * ChessPiece.
 */
public class ChessPieceView extends JLabel {

    private static final ImageIcon BLANK_IMAGE = new ImageIcon("");

    private boolean isOnBoard;

    /**
     * Constructs a PieceView from the given chessPiece.
     *
     * @param piece any ChessPiece or null for a blank JLabel.
     */
    public ChessPieceView(ChessPiece piece) {
        super();
        ImageIcon imageIcon = getImage(piece);
        if (imageIcon.getDescription().length() == 7) {
            isOnBoard = false;
        } else {
            setIcon(imageIcon);
            isOnBoard = true;
        }
    }

    /**
     * Returns the ImageIcon corresponding to the given ChessPiece. A blank
     * ImageIcon is returned if the Piece is null.
     *
     * @param piece the piece to create an ImageIcon for.
     * @return the ImageIcon for the given piece.
     */
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

        return path.equals("images/") ? BLANK_IMAGE : new ImageIcon(path);
    }

    public boolean isOnBoard() {
        return isOnBoard;
    }

    public void capture() {
        setIcon(BLANK_IMAGE);
    }
}

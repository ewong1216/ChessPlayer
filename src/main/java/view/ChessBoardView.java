package view;

import model.ChessCoordinate;
import model.Move;
import model.Square;
import model.pieces.ChessPiece;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is capable of creating a JPanel that shows a
 * ChessBoard.
 */
public class ChessBoardView extends JPanel {

    // The panel that contains the squares (background)
    private final JPanel squaresPanel;
    // The panel that contains the pieces.
    private final JPanel piecesPanel;
    private final Map<ChessPiece, ChessPieceView> piecePieceViewMap;

    /**
     * Creates a new ChessBoardView from the given board,
     * MouseListener and MouseMotionListener.
     *
     * @param board the board to display
     * @param mouseListener the mouseListener for the PieceViews to use.
     * @param motionListener the MouseMotionListener for the PieceViews to use.
     */
    public ChessBoardView(Square[][] board, MouseListener mouseListener,
                          MouseMotionListener motionListener) {
        this.setLayout(new OverlayLayout(this));
        squaresPanel = new JPanel(new GridLayout(8, 8));
        piecesPanel = new JPanel(new GridLayout(8, 8));
        piecePieceViewMap = new HashMap<>();
        initBoardView(board, mouseListener, motionListener);
    }

    public void updateBoard(Move move) {
        if (move != null) {
            if (move.doesCapture()) {
                ChessPieceView capturedPiece = piecePieceViewMap.get(move.getMovingPiece());
                capturedPiece.capture();
            }
            ChessPieceView movingPiece = piecePieceViewMap.get(move.getMovingPiece());
            int movingPieceZOrder = piecesPanel.getComponentZOrder(movingPiece);
            int endSquarePieceZOrder = getZOrder(move.getEndCoordinate());
            ChessPieceView endSquarePiece = (ChessPieceView) piecesPanel
                    .getComponent(endSquarePieceZOrder);
            piecesPanel.setComponentZOrder(movingPiece, endSquarePieceZOrder);
            piecesPanel.setComponentZOrder(endSquarePiece, movingPieceZOrder);
        }
    }

    private static int getZOrder(ChessCoordinate coordinate) {
        return (7 - coordinate.getRank()) * 8 + coordinate.getFile();
    }

    /**
     * Initializes this board View by setting up the piecesPanel and
     * the squaresPanel.
     *
     * @param board the board to display
     * @param mouseListener the MouseListener for the PieceViews to use
     * @param motionListener the MouseMotionListener for the PieceViews to use
     */
    private void initBoardView(Square[][] board, MouseListener mouseListener,
                               MouseMotionListener motionListener) {
        piecesPanel.setOpaque(false);
        for (int rank = 7; rank >= 0; rank--) {
            for (int file = 0; file < 8; file++) {
                ChessPiece piece = board[file][rank].getPiece();
                ChessPieceView pieceView = makePieceView(piece, mouseListener, motionListener);
                piecePieceViewMap.put(piece, pieceView);
                piecesPanel.add(pieceView);
                squaresPanel.add(makeSquare(rank, file));
            }
        }
        this.add(piecesPanel);
        this.add(squaresPanel);
    }

    /**
     * Creates a new Square from the given rank and file.
     *
     * @param rank the rank of this SquareView.
     * @param file the file of this SquareView.
     * @return the SquareView corresponding to the given rank and file.
     */
    private static JPanel makeSquare(int rank, int file) {
        JPanel panel = new JPanel();
        panel.setBackground((rank + file) % 2 == 0 ? Color.DARK_GRAY : Color.LIGHT_GRAY);
        return panel;
    }

    /**
     * Creates a new Square from the given Piece, MouseListener
     * and MouseMotionListener.
     *
     * @param piece the piece on this square.
     * @param mouseListener the MouseListener for this pieceView to use.
     * @param motionListener the MouseMotionListener for this pieceView to use.
     * @return the PieceView representation of this Piece.
     */
    private static ChessPieceView makePieceView(ChessPiece piece, MouseListener mouseListener,
                                        MouseMotionListener motionListener) {
        ChessPieceView pieceView = new ChessPieceView(piece);
        pieceView.addMouseListener(mouseListener);
        pieceView.addMouseMotionListener(motionListener);
        return pieceView;
    }
}

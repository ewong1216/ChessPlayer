package model;

import model.pieces.Bishop;
import model.pieces.ChessPiece;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Queen;
import model.pieces.Rook;

/**
 * This public class is capable of creating new and custom ChessBoards.
 * Given an array of integers corresponding to the pieces, a new ChessBoard
 * Can be made from it.
 */
public class ChessBoardFactory {

    private static final int EMPTY = -1;
    private static final int W_PAWN = 0;
    private static final int B_PAWN = 1;
    private static final int W_ROOK = 2;
    private static final int B_ROOK = 3;
    private static final int W_KNIGHT = 4;
    private static final int B_KNIGHT = 5;
    private static final int W_BISHOP = 6;
    private static final int B_BISHOP = 7;
    private static final int W_QUEEN = 8;
    private static final int B_QUEEN = 9;
    private static final int W_KING = 10;
    private static final int B_KING = 11;

    // Normal chess board
    private static final int[][] normalBoard = {
            {W_ROOK, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_ROOK},
            {W_KNIGHT, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_KNIGHT},
            {W_BISHOP, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_BISHOP},
            {W_QUEEN, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_QUEEN},
            {W_KING, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_KING},
            {W_BISHOP, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_BISHOP},
            {W_KNIGHT, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_KNIGHT},
            {W_ROOK, W_PAWN, EMPTY, EMPTY, EMPTY, EMPTY, B_PAWN, B_ROOK},
    };

    /**
     * Creates a standard chess board with all the pieces in their
     * original positions.
     *
     * @return the ChessBoard with all pieces in their starting positions.
     */
    public static ChessBoard createNormalBoard() {
        return createChessBoard(normalBoard);
    }

    /**
     * Creates a new ChessBoard with a given integer array. The board is
     * created by files. The position at [0][0] corresponds to A1, and the
     * position at [0][7] corresponds to A8 etc..
     *
     * @throws IllegalArgumentException if 'board' is not 8x8.
     * @param board any non-null integer array that is 8x8.
     * @return a ChessBoard from the given 'board'
     */
    public static ChessBoard createChessBoard(int[][] board) {
        if (board.length != 8 || board[0].length != 8) {
            throw new IllegalArgumentException("Board must be 8x8.");
        }

        return new ChessBoard(createSquareArray(board));
    }

    /**
     * creates a square array from the given integer array.
     *
     * @param board any non-null integer array that is 8x8.
     * @return a Square array from the given 'board'
     */
    private static Square[][] createSquareArray(int[][] board) {
        Square[][] squareArray = new Square[8][8];
        for (int file = 0; file < 8; file++) {
            for (int rank = 0; rank < 8; rank++) {
                squareArray[file][rank] = new Square(file, rank, createPiece(board[file][rank]));
            }
        }
        return squareArray;
    }

    /**
     * Creates a new piece from the given 'pieceInt'
     *
     * @param pieceInt the number representation of the pieces
     * @return the piece corresponding to the piece, if no piece exists, null is returned.
     */
    private static ChessPiece createPiece(int pieceInt) {
        switch (pieceInt) {
            case W_PAWN:
                return new Pawn('w');
            case W_ROOK:
                return new Rook('w');
            case W_KNIGHT:
                return new Knight('w');
            case W_BISHOP:
                return new Bishop('w');
            case W_KING:
                return new King('w');
            case W_QUEEN:
                return new Queen('w');
            case B_PAWN:
                return new Pawn('b');
            case B_ROOK:
                return new Rook('b');
            case B_KNIGHT:
                return new Knight('b');
            case B_BISHOP:
                return new Bishop('b');
            case B_QUEEN:
                return new Queen('b');
            case B_KING:
                return new King('b');
            default:
                return null;
        }
    }
}

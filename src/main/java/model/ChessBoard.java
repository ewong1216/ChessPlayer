package model;

import model.pieces.*;

import java.util.Set;

/**
 * Represents a ChessBoard object which contains the 8x8 chess board and the pieces
 * that are in play.
 */
public class ChessBoard {

    // Stores the current state of the chess board.
    // file-major ordering, i.e. board[0] is the A file of the board.
    private final Square[][] board;

    // Stores the piece that moved last for the purposes of En Passant.
    private Square movedLast;

    // Stores references to all of the squares on the board with pieces. Captured pieces are null.
    // pieces[0] stores white pawns, pieces[1] stores white non-pawns, pieces[2][0] stores the white King.
    // pieces[3] stores black pawns, pieces[4] stores black non-pawns, pieces[5][0] stores the black King.
    private Square[][] pieces;

    // Stores the Square of the piece that is doing the check. Null if no check.
    private Square inCheck;

    // Stores the color of which player's turn it is.
    private char playerTurn;

    /**
     * Creates a new ChessBoard Object with the given Square[][].
     *
     * @param board the 2D Square array which represents the ChessBoard.
     */
    public ChessBoard(Square[][] board) {
        this.board = board;
        playerTurn = 'w';
        inCheck = null;
        pieces = new Square[6][8];
        Square[][] tempPieces = new Square[2][16];
        int whitePieceCount = 0;
        int blackPieceCount = 0;
        for(int file = 0; file < 8; file++){
            for(int rank = 0; rank < 8; rank++){
                Square checkIfPiece = board[file][rank];
                ChessPiece piece = checkIfPiece.getPiece();
                if(piece != null){
                    if(piece.getColor() == 'w'){
                        tempPieces[0][whitePieceCount] = checkIfPiece;
                        whitePieceCount++;
                    } else{
                        tempPieces[1][blackPieceCount] = checkIfPiece;
                        blackPieceCount++;
                    }
                }
            }
        }
        sortPieces(tempPieces);
        movedLast = getSquare(0, 1); //TODO: testing purposes, remove when done
    }

    /**
     * Sorts the 2D array of pieces into the pieces field.
     * @param tempPieces a 2D array of ChessPieces where tempPieces[0] holds the white pieces and
     * tempPieces[1] holds the black pieces.
     */
    private void sortPieces(Square[][] tempPieces){
        sortPieces(tempPieces, 0, 0);
        sortPieces(tempPieces, 1,3);
    }

    /**
     * Sorts either the white pieces or black pieces into the pieces field.
     * @param tempPieces a 2D array of ChessPieces where tempPieces[0] holds the white pieces and
     * tempPieces[1] holds the black pieces.
     * @param color 0 for white pieces, 1 for black pieces.
     * @param piecesIndex Used to access the correct array in the 2D pieces array field.
     */
    private void sortPieces(Square[][] tempPieces, int color, int piecesIndex){
        int numPawns = 0;
        int numPieces = 0;
        for(int i = 0; i < 16; i++){
            Square squareWithPiece = tempPieces[color][i];
            if(squareWithPiece == null){
                break;
            } else if(squareWithPiece.getPiece().getClass() == Pawn.class){
                pieces[piecesIndex][numPawns] = squareWithPiece;
                numPawns++;
            } else if(squareWithPiece.getPiece().getClass() != King.class){
                pieces[piecesIndex+1][numPieces] = squareWithPiece;
                numPieces++;
            } else{
                pieces[piecesIndex+2][0] = squareWithPiece;
            }
        }
    }

    /**
     * Returns a String representation of this ChessBoard.
     *
     * @return a formatted chess board with black pieces in uppercase and
     * white pieces in lowercase.
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int rank = 7; rank > -1; rank--) {
            result.append(rank + 1).append("|");
            for(int file = 0; file < 8; file++) {
                if(board[file][rank] != null) {
                    result.append(board[file][rank].toString()).append(" ");
                } else {
                    result.append("  ");
                }
            }
            result.append("\n");
        }
        result.append(" ----------------\n");
        result.append("  A B C D E F G H");
        return result.toString();
    }

    public Square[][] getBoard(){
        return board;
    }

    /**
     * Returns a reference to the square at the given file and rank.
     *
     * @param file an int 0-7 which corresponds to files A_H.
     * @param rank an int 0-7 which corresponds to ranks 1-8.
     * @return a reference to the square. If the square is out of bounds, returns null.
     */
    public Square getSquare(int file, int rank){
        if(file > 7 || rank > 7 || file < 0 || rank < 0){
            return null;
        } else {
            return board[file][rank];
        }
    }

    /**
     * Determines whether the given square is attacked by the color opposite the given color.
     *
     * @param square the square to check if it is being attacked.
     * @param color the color of the piece on (or that would be on) the square
     * @return true if the square is attacked by a piece of the opposite color, false if not.
     */
    public boolean isSquareAttacked(Square square, char color){
        int piecesIndex;
        if(color == 'b'){
            piecesIndex = 0;
        } else {
            piecesIndex = 3;
        }
        for(int i = 0; i < 3; i++,piecesIndex++){
            for(int piece = 0; piece < 8; piece++){
                Square enemyPieceSquare = pieces[piecesIndex][piece];
                if(enemyPieceSquare == null){
                    break;
                }
                ChessPiece enemyPiece = enemyPieceSquare.getPiece();
                if(enemyPiece == null){
                    break;
                }
                Set<Square> attacked;
                ChessPiece tempPiece = square.getPiece();
                square.setPiece(new Rook(color)); // Temporary give it a piece so the enemyPiece can detect a capture.
                if(enemyPiece.getClass() == Pawn.class){
                    attacked = enemyPiece.possibleCaptures(enemyPieceSquare, this);
                } else {
                    attacked = enemyPiece.possibleMoves(enemyPieceSquare, this);
                    attacked.addAll(enemyPiece.possibleCaptures(enemyPieceSquare, this));
                }
                square.setPiece(tempPiece); // Replace the temporary piece.
                if(attacked.contains(square)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean makeMove(String move) {
        if(move.length() == 2){
            //TODO: this is a pawn move, ex. e4, c5, etc. Only pawn moves are 2 chars long.
        }
        return false;
    }

    public void movePiece(Square end){
        //TODO: update movedLast
        throw new UnsupportedOperationException();
    }

    public void tempSetMovedLast(Square square){
        movedLast = square;
    }

    /**
     * Gets the piece at the given coordinate.
     *
     * @param coordinate any non-null coordinate.
     * @return the piece at the given coordinate.
     */
    public ChessPiece getPieceOnSquare(ChessCoordinate coordinate) {
        return board[coordinate.getFile()][coordinate.getRank()].getPiece();
    }

    /**
     * Used for the purposes of En Passant for Pawns.
     *
     * @return the Square of the piece that moved most recently.
     */
    public Square getMovedLast(){
        return movedLast;
    }

    /**
     * Returns the Square of the piece that is checking.
     * @return The Square on which the checking piece resides. Null if no check on the board.
     */
    public Square getInCheck(){
        return inCheck;
    }

}
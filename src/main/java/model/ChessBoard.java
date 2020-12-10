package model;

import model.pieces.ChessPiece;
import model.pieces.King;
import model.pieces.Pawn;
import model.pieces.Queen;
import model.pieces.Rook;

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

    /**
     * Creates a new ChessBoard Object with the given Square[][].
     *
     * @param board the 2D Square array which represents the ChessBoard.
     */
    public ChessBoard(Square[][] board) {
        this.board = board;
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
        movedLast = getSquare(0, 0);
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

    public Square getSquare(ChessCoordinate coords){
        return getSquare(coords.getFile(), coords.getRank());
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
                    continue;
                }
                ChessPiece enemyPiece = enemyPieceSquare.getPiece();
                if(enemyPiece == null){
                    continue;
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

    public boolean areSquaresAttacked(char color, Square[] squares) {
        for(Square square : squares){
            if(isSquareAttacked(square, color)){
                return true;
            }
        }
        return false;
    }

    public Move makeMove(Square start, Square end) {
        boolean isCapture;
        boolean isEnpassant = false;
        char playerTurn = start.getPiece().getColor();
        if(end.isOccupied()) {
            isCapture = true;
        } else if(start.getPiece().getClass() == Pawn.class && !end.isOccupied() && start.getFile() != end.getFile()){
            isCapture = true; // En Passant
            isEnpassant = true;
        } else {
            isCapture = false;
        }

        Move move = null;
        if(isCapture && start.getPiece().possibleCaptures(start, this).contains(end)){ // If capture is valid
            if(isEnpassant){
                Square capturedPawn = getSquare(end.getFile(), end.getRank() + move(playerTurn));
                move = new Move(start.getPiece(), capturedPawn.getPiece(), start.getCoordinate(), end.getCoordinate(), capturedPawn.getCoordinate());
                removePiece(capturedPawn, capturedPawn.getPiece().getColor());
                end.setPiece(start.getPiece());
                capturedPawn.clear();
            } else {
                move = new Move(start.getPiece(), end.getPiece(), start.getCoordinate(), end.getCoordinate(), end.getCoordinate());
                removePiece(end, end.getPiece().getColor());
                end.setPiece(start.getPiece());
                move.getMovingPiece().moved();
            }
            start.clear();
            changePiecesReference(start, end);
        } else if(start.getPiece().possibleMoves(start, this).contains(end)){ // If move is valid
            move = new Move(start.getPiece(), null, start.getCoordinate(), end.getCoordinate(), null);
            end.setPiece(start.getPiece());
            start.clear();
            changePiecesReference(start, end);
        } else if(start.getPiece().getClass() == King.class && !start.getPiece().hasMoved()){ // Castling
            int rank = start.getRank();
            if(end.getRank() == rank && end.getFile() == start.getFile() + 2){ // King-side castling
                Square[] toCheck = new Square[3];
                toCheck[0] = start;
                toCheck[1] = getSquare(start.getFile() + 1, rank);
                toCheck[2] = end;
                Square rook = getSquare(start.getFile() + 3, rank);
                if(!toCheck[1].isOccupied() && !toCheck[2].isOccupied() && rook.isOccupied() && !rook.getPiece().hasMoved()){ // Can't castle through pieces
                    if(!areSquaresAttacked(playerTurn, toCheck)){ // Can't castle while in check, through check, or into check.
                        move = new Move(start.getPiece(), null,start.getCoordinate(),end.getCoordinate(),null);
                        end.setPiece(start.getPiece());
                        start.clear();
                        changePiecesReference(start, end);
                        toCheck[1].setPiece(rook.getPiece());
                        rook.clear();
                        changePiecesReference(rook,toCheck[1]);
                    }
                }
            } else if(end.getRank() == rank && end.getFile() == start.getFile() - 2){ // Queen-side castling
                Square[] toCheck = new Square[3];
                toCheck[0] = start;
                toCheck[1] = getSquare(start.getFile() - 1, rank);
                toCheck[2] = end;
                Square rook = getSquare(0, rank);
                if(!toCheck[1].isOccupied() && !toCheck[2].isOccupied() && !getSquare(1, rank).isOccupied() &&
                        rook.isOccupied() && !rook.getPiece().hasMoved()) { //Can't castle through pieces
                    if(!areSquaresAttacked(playerTurn,toCheck)){
                        move = new Move(start.getPiece(),null,start.getCoordinate(), end.getCoordinate(),null);
                        end.setPiece(start.getPiece());
                        start.clear();
                        changePiecesReference(start, end);
                        toCheck[1].setPiece(rook.getPiece());
                        rook.clear();
                        changePiecesReference(rook,toCheck[1]);
                    }
                }
            }
        }

        if(move != null && isSquareAttacked(pieces[kingColorIndex(playerTurn)][0], playerTurn)){ // If the move/capture made created a check, reset.
            start.setPiece(move.getMovingPiece()); // Reset moving piece
            if(isEnpassant){
                getSquare(end.getCoordinate()).clear();
                Square capturedPawn = getSquare(move.getCapturedStartCoordinate());
                capturedPawn.setPiece(move.getCapturedPiece());
                addPieceBack(capturedPawn, capturedPawn.getPiece().getColor());
            } else if(isCapture){
                getSquare(end.getCoordinate()).setPiece(move.getCapturedPiece());
                addPieceBack(end, end.getPiece().getColor());
            } else {
                end.clear();
            }
            changePiecesReference(end, start);
            return null;
        } else {
            if(move != null) {
                if(end.getPiece().getClass() == Pawn.class && (end.getRank() == 0 || end.getRank() == 7)) {
                    end.setPiece(new Queen(end.getPiece().getColor()));
                    move = new Move(end.getPiece(),move.getCapturedPiece(),move.getStartCoordinate(),move.getEndCoordinate(),move.getCapturedStartCoordinate());
                }
                end.getPiece().moved();
                movedLast = end;
            }
            return move;
        }
    }

    private void changePiecesReference(Square original, Square newSquare){
        for(int piecetype = 0; piecetype < 6; piecetype++){
            for(int i = 0; i < 8; i++){
                Square toCheck = pieces[piecetype][i];
                if(toCheck != null && toCheck.equals(original)){
                    pieces[piecetype][i] = newSquare;
                    return;
                }
            }
        }
    }
    private void removePiece(Square piece, char color){
        int index = 0;
        if(color != 'w'){
            index = 3;
        }
        for(int piecetype = 0; piecetype < 2; piecetype++){
            for(int i = 0; i < 8; i++){
                Square checkSquare = pieces[piecetype  + index][i];
                if(checkSquare != null && checkSquare.equals(piece)) {
                    pieces[piecetype  + index][i] = null;
                    return;
                }
            }
        }
    }

    private void addPieceBack(Square piece, char color){
        int index = 0;
        if(color != 'w'){
            index = 3;
        }
        int piecetype = 0;
        if(piece.getPiece().getClass() != Pawn.class) {
            piecetype = 1;
        }
        for(int i = 0; i < 8; i++){
            Square checkSquare = pieces[piecetype + index][i];
            if(checkSquare == null) {
                pieces[piecetype + index][i] = piece;
                return;
            }
        }
    }

    private int kingColorIndex(char color){
        if(color == 'w'){
            return 2;
        } else {
            return 5;
        }
    }
    /**
     * Look for the pawn 1 behind the en passant square.
     * @param color dictates which direction to get the Square with the pawn.
     * @return -1 for white, 1 for black.
     */
    private int move(char color) {
        if(color == 'w'){
            return -1;
        } else {
            return 1;
        }
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
}
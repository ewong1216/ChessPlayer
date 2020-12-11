package model;

import model.pieces.ChessPiece;

public class Move {

    private final ChessPiece movingPiece;
    private final ChessPiece capturedPiece;
    private final ChessCoordinate startCoordinate;
    private final ChessCoordinate endCoordinate;
    private final ChessCoordinate capturedStartCoordinate;
    private final boolean isPromotion;

    public Move(ChessPiece movingPiece, ChessPiece capturedPiece, ChessCoordinate startCoordinate,
                ChessCoordinate endCoordinate, ChessCoordinate capturedStartCoordinate) {
        this(movingPiece,capturedPiece,startCoordinate,endCoordinate,capturedStartCoordinate, false);
    }

    public Move(ChessPiece movingPiece, ChessPiece capturedPiece, ChessCoordinate startCoordinate,
                ChessCoordinate endCoordinate, ChessCoordinate capturedStartCoordinate, boolean isPromotion) {
        this.movingPiece = movingPiece;
        this.capturedPiece = capturedPiece;
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        this.capturedStartCoordinate = capturedStartCoordinate;
        this.isPromotion = isPromotion;
    }

    public ChessPiece getMovingPiece() {
        return movingPiece;
    }

    public ChessPiece getCapturedPiece() {
        return capturedPiece;
    }

    public ChessCoordinate getStartCoordinate() {
        return startCoordinate;
    }

    public ChessCoordinate getEndCoordinate() {
        return endCoordinate;
    }

    public ChessCoordinate getCapturedStartCoordinate() {
        return capturedStartCoordinate;
    }

    public boolean doesCapture() {
        return capturedPiece != null;
    }

    public boolean getIsPromotion(){
        return isPromotion;
    }
}

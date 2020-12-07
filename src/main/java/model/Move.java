package model;

import model.pieces.ChessPiece;

public class Move {

    private final ChessPiece movingPiece;
    private final ChessPiece capturedPiece;
    private final ChessCoordinate startCoordinate;
    private final ChessCoordinate endCoordinate;
    private final ChessCoordinate capturedStartCoordinate;

    public Move(ChessPiece movingPiece, ChessPiece capturedPiece, ChessCoordinate startCoordinate,
                ChessCoordinate endCoordinate, ChessCoordinate capturedStartCoordinate) {
        this.movingPiece = movingPiece;
        this.capturedPiece = capturedPiece;
        this.startCoordinate = startCoordinate;
        this.endCoordinate = endCoordinate;
        this.capturedStartCoordinate = capturedStartCoordinate;
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
}

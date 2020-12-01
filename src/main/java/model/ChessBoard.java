package model;

import model.pieces.Bishop;
import model.pieces.King;
import model.pieces.Knight;
import model.pieces.Pawn;
import model.pieces.Queen;
import model.pieces.Rook;

public class ChessBoard {
    private Square[][] board;

    public ChessBoard() {
        board = new Square[8][8];
        for(int file = 0; file < 8; file++) {
            board[file][1] = new Square(file, 1, new Pawn('w'));
            board[file][6] = new Square(file, 7, new Pawn('b'));
            for(int rank = 2; rank < 6; rank++) {
                board[file][rank] = new Square(file, rank);
            }
        }
        createNonPawns(0, 'w');
        createNonPawns(7, 'b');
    }

    public ChessBoard(Square[][] board) {
        this.board = board;
    }

    private void createNonPawns(int rank, char color) {
        board[0][rank] = new Square(0, rank, new Rook(color));
        board[1][rank] = new Square(1, rank, new Knight(color));
        board[2][rank] = new Square(2, rank, new Bishop(color));
        board[3][rank] = new Square(3, rank, new Queen(color));
        board[4][rank] = new Square(4, rank, new King(color));
        board[5][rank] = new Square(5, rank, new Bishop(color));
        board[6][rank] = new Square(6, rank, new Knight(color));
        board[7][rank] = new Square(7, rank, new Rook(color));
    }
    public String toString(){
        String result = "";
        for(int rank = 7; rank > -1; rank--) {
            result += rank + 1 + "|";
            for(int file = 0; file < 8; file++) {
                if(board[file][rank] != null) {
                    result += board[file][rank].toString() + " ";
                } else {
                    result += "  ";
                }
            }
            result += "\n";
        }
        result += " ----------------\n";
        result += "  A B C D E F G H";
        return result;
    }
}

package model;

public class ChessBoard {
    private final Square[][] board;

    public ChessBoard(Square[][] board) {
        this.board = board;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int rank = 7; rank > -1; rank--) {
            result.append(rank).append(1).append("|");
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
}

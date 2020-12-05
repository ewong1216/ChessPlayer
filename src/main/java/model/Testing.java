package model;

public class Testing {

    public static void main(String[] args){
        int[][] intboard = new int[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                intboard[i][j] = ChessBoardFactory.EMPTY;
            }
        }
        intboard[2][4] = ChessBoardFactory.W_PAWN;
        intboard[3][4] = ChessBoardFactory.B_PAWN;
        intboard[1][5] = ChessBoardFactory.B_PAWN;
        intboard[1][4] = ChessBoardFactory.W_ROOK;
        intboard[1][0] = ChessBoardFactory.B_BISHOP;

        //Pawn moving and capturing test
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);
//        board.tempSetMovedLast(board.getSquare(3,4));
//        System.out.println(board);
//
//        Square whitepawn = board.getSquare(2,4);
//        whitepawn.piece().moved();
//        System.out.println(whitepawn.piece().possibleCaptures(whitepawn,board));
//
//        System.out.println(whitepawn.piece().possibleMoves(whitepawn,board));

        // Rook moving and capturing test
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);
//        System.out.println(board);
//        Square rook = board.getSquare(1,4);
//        //rook.piece().possibleMoves(rook, board);
//        System.out.println(rook.piece().possibleCaptures(rook,board));

        // Testing ChessBoard constructor
//        ChessBoard board = ChessBoardFactory.createNormalBoard();
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);

    }

}

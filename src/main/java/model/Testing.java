package model;

import model.ChessBoard;
import model.ChessBoardFactory;

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
        intboard[4][3] = ChessBoardFactory.W_PAWN;
        intboard[0][1] = ChessBoardFactory.W_ROOK;


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

        // model.Testing ChessBoard constructor
        ChessBoard board = ChessBoardFactory.createNormalBoard();
        System.out.println(board);
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);

        // model.Testing Bishop moving, capturing.
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);
//        System.out.println(board);
//        Square bishop = board.getSquare(1,0);
//        System.out.println(bishop.getPiece().possibleMoves(bishop,board));
//        System.out.println(bishop.getPiece().possibleCaptures(bishop,board));

    }

}

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
//        ChessBoard board = ChessBoardFactory.createNormalBoard();
//        System.out.println(board);
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);

        // model.Testing Bishop moving, capturing.
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);
//        System.out.println(board);
//        Square bishop = board.getSquare(1,0);
//        System.out.println(bishop.getPiece().possibleMoves(bishop,board));
//        System.out.println(bishop.getPiece().possibleCaptures(bishop,board));

        // Testing ChessBoard.isSquareAttacked, King movement
//        intboard[3][3] = ChessBoardFactory.W_KING;
        //intboard[4][5] = ChessBoardFactory.B_PAWN;
//        intboard[5][6] = ChessBoardFactory.B_BISHOP;
//        ChessBoard board = ChessBoardFactory.createChessBoard(intboard);
//        System.out.println(board);
//        System.out.println(board.isSquareAttacked(board.getSquare(1, 1), 'w'));
//        System.out.println(board.isSquareAttacked(board.getSquare(1, 2), 'w'));
//        System.out.println(board.isSquareAttacked(board.getSquare(1, 3), 'w'));
//        System.out.println(board.isSquareAttacked(board.getSquare(2, 1), 'w'));
//        System.out.println(board.isSquareAttacked(board.getSquare(2, 3), 'w'));
//        System.out.println(board.isSquareAttacked(board.getSquare(3, 1), 'w'));
//        System.out.println(board.isSquareAttacked(board.getSquare(3, 2), 'w'));
//        System.out.println(board.isSquareAttacked(board.getSquare(3, 3), 'w'));
//        Square king = board.getSquare(3, 3);
//        System.out.println(king.getPiece().possibleMoves(king, board));
//        System.out.println(king.getPiece().possibleCaptures(king, board));

        // Testing moves while in check
//        ChessBoard board = ChessBoardFactory.createNormalBoard();
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,1), board.getSquare(4,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,6), board.getSquare(3,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,3), board.getSquare(3,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,7), board.getSquare(3,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(1,0), board.getSquare(2,2));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,4), board.getSquare(3,7));
//        System.out.println(board);
//        board.makeMove(board.getSquare(5,0), board.getSquare(1,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(2,6), board.getSquare(2,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(1,4), board.getSquare(2,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(2,7), board.getSquare(6,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,0), board.getSquare(6,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,7), board.getSquare(3,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(6,3), board.getSquare(2,7));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,5), board.getSquare(3,7));
//        System.out.println(board);
//        board.makeMove(board.getSquare(2,3), board.getSquare(5,6));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,7), board.getSquare(5,6));
//        System.out.println(board);

        // Testing Castling
//        ChessBoard board = ChessBoardFactory.createNormalBoard();
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,1), board.getSquare(3,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,6), board.getSquare(3,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(1,0), board.getSquare(2,2));
//        System.out.println(board);
//        board.makeMove(board.getSquare(1,7), board.getSquare(2,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(2,0), board.getSquare(5,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(2,7), board.getSquare(5,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,0), board.getSquare(3,1));
//        System.out.println(board);
//        board.makeMove(board.getSquare(3,7), board.getSquare(3,6));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,0), board.getSquare(2,0));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,7), board.getSquare(2,7));
//        System.out.println(board);

        // Testing promotion
//        ChessBoard board = ChessBoardFactory.createNormalBoard();
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,1), board.getSquare(4,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(5,6), board.getSquare(5,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,3), board.getSquare(5,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(6,6), board.getSquare(6,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(5,4), board.getSquare(6,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(6,7), board.getSquare(5,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(6,5), board.getSquare(6,6));
//        System.out.println(board);
//        board.makeMove(board.getSquare(1,6), board.getSquare(1,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(6,6), board.getSquare(7,7));
//        System.out.println(board);
//        board.makeMove(board.getSquare(0,6), board.getSquare(0,5));
//        System.out.println(board);
//        board.makeMove(board.getSquare(7,7), board.getSquare(7,6));
//        System.out.println(board);

        // Testing bug
//        ChessBoard board = ChessBoardFactory.createNormalBoard();
//        System.out.println(board);
//        board.makeMove(board.getSquare(1,0), board.getSquare(2,2));
//        System.out.println(board);
//        board.makeMove(board.getSquare(5,6), board.getSquare(5,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(2,2), board.getSquare(1,0));
//        System.out.println(board);
//        board.makeMove(board.getSquare(5,4), board.getSquare(5,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,1), board.getSquare(4,3));
//        System.out.println(board);
//        board.makeMove(board.getSquare(5,3), board.getSquare(4,2));
//        System.out.println(board);

        // Testing moving King into check
//        ChessBoard board = ChessBoardFactory.createNormalBoard();
//        System.out.println(board);
//        board.makeMove(board.getSquare(6,0), board.getSquare(5,2));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,6), board.getSquare(4,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(5,2), board.getSquare(6,4));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,7), board.getSquare(4,6));
//        System.out.println(board);
//        board.makeMove(board.getSquare(0,1), board.getSquare(0,2));
//        System.out.println(board);
//        board.makeMove(board.getSquare(4,6), board.getSquare(4,5));
//        System.out.println(board);


    }

}

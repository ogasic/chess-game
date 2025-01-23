package chessLogic;
import android.util.Log;

import Interfaces.ChessGameLogic;
import Interfaces.ChessPieceEnums;

public class ChessLogicBoard implements ChessGameLogic {


    private ChessPieceEnums[][] enumBoard = {
            {ChessPieceEnums.BLACK_ROOK, ChessPieceEnums.BLACK_KNIGHT, ChessPieceEnums.BLACK_BISHOP, ChessPieceEnums.BLACK_QUEEN,
                    ChessPieceEnums.BLACK_KING, ChessPieceEnums.BLACK_BISHOP, ChessPieceEnums.BLACK_KNIGHT, ChessPieceEnums.BLACK_ROOK},
            {ChessPieceEnums.BLACK_PAWN, ChessPieceEnums.BLACK_PAWN, ChessPieceEnums.BLACK_PAWN, ChessPieceEnums.BLACK_PAWN,
                    ChessPieceEnums.BLACK_PAWN, ChessPieceEnums.BLACK_PAWN, ChessPieceEnums.BLACK_PAWN, ChessPieceEnums.BLACK_PAWN},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {ChessPieceEnums.WHITE_PAWN, ChessPieceEnums.WHITE_PAWN, ChessPieceEnums.WHITE_PAWN, ChessPieceEnums.WHITE_PAWN
                    , ChessPieceEnums.WHITE_PAWN, ChessPieceEnums.WHITE_PAWN, ChessPieceEnums.WHITE_PAWN, ChessPieceEnums.WHITE_PAWN},
            {ChessPieceEnums.WHITE_ROOK, ChessPieceEnums.WHITE_KNIGHT, ChessPieceEnums.WHITE_BISHOP, ChessPieceEnums.WHITE_QUEEN,
                    ChessPieceEnums.WHITE_KING, ChessPieceEnums.WHITE_BISHOP, ChessPieceEnums.WHITE_KNIGHT, ChessPieceEnums.WHITE_ROOK}};

    private LogicPiece[][] logicPieces = {
            {new Rook(LogicPiece.BLACK), new Knight(LogicPiece.BLACK), new Bishop(LogicPiece.BLACK), new Queen(LogicPiece.BLACK)
                    , new King(LogicPiece.BLACK), new Bishop(LogicPiece.BLACK), new Knight(LogicPiece.BLACK), new Rook(LogicPiece.BLACK)},
            {new Pawn(LogicPiece.BLACK), new Pawn(LogicPiece.BLACK), new Pawn(LogicPiece.BLACK), new Pawn(LogicPiece.BLACK)
                    , new Pawn(LogicPiece.BLACK), new Pawn(LogicPiece.BLACK), new Pawn(LogicPiece.BLACK), new Pawn(LogicPiece.BLACK)},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {new Pawn(LogicPiece.WHITE), new Pawn(LogicPiece.WHITE), new Pawn(LogicPiece.WHITE), new Pawn(LogicPiece.WHITE)
                    , new Pawn(LogicPiece.WHITE), new Pawn(LogicPiece.WHITE), new Pawn(LogicPiece.WHITE), new Pawn(LogicPiece.WHITE)},
            {new Rook(LogicPiece.WHITE), new Knight(LogicPiece.WHITE), new Bishop(LogicPiece.WHITE), new Queen(LogicPiece.WHITE)
                    , new King(LogicPiece.WHITE), new Bishop(LogicPiece.WHITE), new Knight(LogicPiece.WHITE), new Rook(LogicPiece.WHITE)}};


    public ChessLogicBoard() {

        //every piece gets a reference to the board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (logicPieces[i][j] != null){
                    logicPieces[i][j].setBoard(logicPieces);
                }
            }
        }

    }




    @Override
    public boolean makeMove(int x,int y,int x1,int y1) {

         if (!isMoveValid(x , y , x1 , y1)) {
             return false;
         }
        if (enumBoard[y][x] == null)
            return false;



        enumBoard[y1][x1] = enumBoard[y][x];
        enumBoard[y][x] = null;

        logicPieces[y1][x1] = logicPieces[y][x];
        logicPieces[y][x] = null;


        return true;
    }

    @Override
    public ChessPieceEnums[][] getBoard() {
        return enumBoard;
    }
    public boolean getColor(int x,int y){

        if (enumBoard[y][x] == null)
            return false;
        String enu = enumBoard[y][x].toString();

        return enu.startsWith("WHITE");

    }

    @Override
    public boolean isEmptyField(int x, int y) {
        return enumBoard[y][x] == null ;
    }

    private boolean isMoveValid(int x,int y,int x1,int y1){

       if (x == x1 && y == y1)
           return false;

        int counter = 0;
        LogicPiece toEvaluate = logicPieces[y][x];
        Pair[] legalMoves = toEvaluate.getLegalMove();
        while (legalMoves[counter] != null){
            if(legalMoves[counter].getX() == x1 && legalMoves[counter].getY() == y1){
                return true;
            }
            counter++;
        }

        return false;
    }
    public Pair[] getLegalMoves(int x ,int y){

        LogicPiece toEvaluate = logicPieces[x][y];
        Log.i(x+" " +y+"","GET LEGAL MOVES");
        return toEvaluate.getLegalMove();


    }
}

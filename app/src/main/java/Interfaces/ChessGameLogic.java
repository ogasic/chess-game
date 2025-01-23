package Interfaces;

import chessLogic.Pair;

public interface ChessGameLogic {


    public boolean makeMove(int x,int y,int x1 ,int y1);


    public ChessPieceEnums[][] getBoard();

    public boolean getColor(int x,int y);

    public boolean isEmptyField(int x, int y);
    public Pair[] getLegalMoves(int x , int y);
}

package chessLogic;

import android.util.Log;

public class Pawn extends LogicPiece{

    public Pawn(int color) {
        super(color);
    }

    @Override
    public Pair[] getLegalMove() {



        Pair position = getSelfPosition();
        LogicPiece evaluate = board[position.getX()][position.getY()];
        Pair[] moves = new Pair[64];

        if (position.getX() == 7 || position.getX() == 0){
            return moves;
        }
        int counter = 0;
        if (evaluate.color == WHITE){
            if (board[position.getX()-1][position.getY()] == null){
                moves[counter++] = new Pair(position.getY(),position.getX()-1);
            }
            if (position.getX() == 6 && moves[0] != null && board[position.getX()-2][position.getY()] == null){
                moves[counter++] = new Pair(position.getY(),position.getX()-2);
            }
            if (position.getY() >  0   &&  board[position.getX()-1][position.getY()-1] != null && board[position.getX()-1][position.getY()-1].color == BLACK ){
                moves[counter++] = new Pair(position.getY()-1,position.getX()-1);
            }
            if (position.getY() < 7 && board[position.getX()-1][position.getY()+1] != null && board[position.getX()-1][position.getY()+1].color == BLACK ){
                moves[counter++] = new Pair(position.getY()+1,position.getX()-1);
            }

        }
        if (evaluate.color == BLACK){
            if (board[position.getX()+1][position.getY()] == null){
                moves[counter++] = new Pair(position.getY(),position.getX()+1);
            }
            if (position.getX() == 1 && moves[0] != null && board[position.getX()+2][position.getY()] == null){
                moves[counter++] = new Pair(position.getY(),position.getX()+2);
            }
            if (position.getY() > 0 && board[position.getX()+1][position.getY()-1] != null && board[position.getX()+1][position.getY()-1].color == WHITE ){

                moves[counter++] = new Pair(position.getY()-1,position.getX()+1);
            }
            if (position.getY() < 7 && board[position.getX()+1][position.getY()+1] != null && board[position.getX()+1][position.getY()+1].color == WHITE ){
                moves[counter++] = new Pair(position.getY()+1,position.getX()+1);
            }

        }
        moves[counter] = null;


        return moves;

    }
}

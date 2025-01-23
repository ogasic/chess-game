package chessLogic;

public abstract class LogicPiece {


    static final int WHITE = 1;
    static final int BLACK = 2;
    int color;
    LogicPiece[][] board;

    public LogicPiece(int color ){
        this.color = color;


    }
    public abstract Pair[] getLegalMove();

    public Pair getSelfPosition(){

        for (int i = 0 ; i < 8 ; i++){
            for (int j = 0 ; j < 8 ; j++){
                if (board[i][j] == this){
                    return new Pair(i,j);
                }
            }
        }
        return null;
    }
    public void setBoard(LogicPiece[][] board){
        this.board = board;
    }

}

package chessLogic;

public class Pair {

    int x;
    int y;

    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean compareMoves(Pair pair){

        return this.x == pair.x && this.y == pair.y;
    }

}

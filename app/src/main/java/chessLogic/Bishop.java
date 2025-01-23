package chessLogic;

public class Bishop extends LogicPiece{
    public Bishop(int color) {
        super(color);
    }

    @Override
    public Pair[] getLegalMove() {
        return new Pair[0];
    }
}

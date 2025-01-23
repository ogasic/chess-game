package chessLogic;

public class Knight extends LogicPiece{
    public Knight(int color) {
        super(color);
    }

    @Override
    public Pair[] getLegalMove() {
        return new Pair[1];
    }
}

package chessLogic;

public class Queen extends LogicPiece{

    public Queen(int color) {
        super(color);
    }

    @Override
    public Pair[] getLegalMove() {
        return new Pair[0];
    }
}

package chessLogic;

public class Rook extends LogicPiece{
    public Rook(int color) {
        super(color);
    }

    @Override
    public Pair[] getLegalMove() {
        return new Pair[0];
    }
}

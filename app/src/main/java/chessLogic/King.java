package chessLogic;

public class King extends LogicPiece{
    public King(int color) {
        super(color);
    }

    @Override
    public Pair[] getLegalMove() {
        return new Pair[0];
    }
}

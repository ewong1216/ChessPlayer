package Model;

public class Rook extends ChessPiece{
    public Rook(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public boolean canCapture(Square start, Square enemy) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.getColor() == 'w') {
            return "r";
        } else {
            return "R";
        }
    }
}

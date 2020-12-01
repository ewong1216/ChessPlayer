package Model;

public class Queen extends ChessPiece{
    public Queen(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        return false;
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.color == 'w') {
            return "q";
        } else {
            return "Q";
        }
    }
}

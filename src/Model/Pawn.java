package Model;

public class Pawn extends ChessPiece {

    public Pawn(char color) {
        super(color);
    }

    public boolean canMoveTo(Square start, Square finish) {
        if(finish.isOccupied()) {
            return false;
        } else if(finish.getRank() == start.getRank() + 1) {
            return true;
        } else if(!super.hasMoved() && finish.getRank() == start.getRank() + 2) {
            return true;
        } else {
            return false;
        }
    }

    public boolean canCapture(Square start, Square enemy) {
        if(super.getColor() == 'w') {

        }
    }

    public void moveTo(Square square) {

    }

    public String toString() {
        if(super.getColor() == 'w') {
            return "p";
        } else {
            return "P";
        }
    }
}

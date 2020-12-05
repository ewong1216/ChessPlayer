package model;

public class ChessCoordinate {

    private final int file;

    private final int rank;

    public ChessCoordinate(int file, int rank){
        this.file = file;
        this.rank = rank;
    }

    public int getFile(){
        return file;
    }

    public int getRank(){
        return rank;
    }

    public boolean equals(Object other){
        if(this == other){
            return true;
        } else if(other.getClass() != ChessCoordinate.class){
            return false;
        } else {
            ChessCoordinate otherCoord = (ChessCoordinate) other;
            return file == otherCoord.file && rank == otherCoord.rank;
        }
    }
}

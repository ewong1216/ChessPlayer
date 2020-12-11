package model;

import java.util.Objects;

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

    public boolean isInBounds() {
        return (0 <= file && file <= 7) && (0 <= rank && rank <= 7);
    }

    @Override
    public String toString() {
        return "ChessCoordinate{" +
                "file=" + file +
                ", rank=" + rank +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessCoordinate)) return false;
        ChessCoordinate that = (ChessCoordinate) o;
        return file == that.file &&
                rank == that.rank;
    }
}

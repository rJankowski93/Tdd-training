package codingdojo;

import java.util.Objects;

public class Seat {

    public String row;
    public int seatNumber;

    public Seat(String row, int seatNumber) {
        this.row = row;
        this.seatNumber = seatNumber;
    }

    public String getRow() {
        return row;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public Seat(String seatString) {
        this(seatString.substring(0, 1), Integer.parseInt(seatString.substring(1)));
    }

    public String toString() {
        return this.row + this.seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatNumber, seat.seatNumber) &&
                Objects.equals(row, seat.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seatNumber);
    }
}

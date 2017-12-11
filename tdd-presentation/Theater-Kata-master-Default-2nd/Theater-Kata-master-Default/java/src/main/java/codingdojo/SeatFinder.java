package codingdojo;

import java.util.*;

public class SeatFinder {

    private Theater theater;
    private List<Seat> booked;

    public SeatFinder(Theater theater) {
        this(theater, new ArrayList<Seat>());
    }

    public SeatFinder(Theater theater, List<Seat> booked) {
        this.theater = theater;
        this.booked = booked;
    }

    public Set<Seat> suggest(int partySize) {

        for (String row : theater.rows) {
            if (isRowApplicable(row, partySize)) {
                return getFreeSeats(row, partySize);
            }
        }

        return null;
    }

    private Set<Seat> getFreeSeats(String row, int partySize) {
        List<Integer> seats = theater.seats.get(row);
        int center = (seats.size() - partySize) / 2 + 1;
        int offset = 0;
        int bookFrom = center + offset;

        int leftCenter = 5;
        int rightCenter = 6;

        boolean leftBrake = true;
        boolean rightBrake = true;

        HashSet<Seat> freeSeats = new HashSet<>();

        while (freeSeats.size() < partySize && offset < 5) {

            if (partySize == 2 && !isBooked(row, leftCenter) && !isBooked(row, rightCenter)) {
                freeSeats.add(new Seat(row, leftCenter));
                freeSeats.add(new Seat(row, rightCenter));
                return freeSeats;
            }

            if (!isBooked(row, rightCenter + offset)) {

                freeSeats.add(new Seat(row, rightCenter + offset));

            }
            if (!isBooked(row, leftCenter - offset)) {

                freeSeats.add(new Seat(row, leftCenter - offset));

            }
            offset++;
        }

        return freeSeats;
    }

    private boolean isRowApplicable(String rowName, int partySize) {
        return theater.seats.get(rowName).size()
                - booked.stream().filter(x -> x.getRow().equals(rowName)).count() >= partySize;
    }

    private boolean isBooked(String row, Integer col) {
        return booked.stream().filter(x -> x.getRow().equals(row) && x.getSeatNumber() == col)
                .count() > 0;
    }

    private HashSet getSuggestedSeats(Seat... names) {
        return new HashSet(Arrays.asList(names));
    }

}

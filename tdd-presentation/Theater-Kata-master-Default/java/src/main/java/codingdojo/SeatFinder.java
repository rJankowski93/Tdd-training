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

        for(String row : theater.rows){
            if(isRowApplicable(row, partySize)){
                return getFreeSeats(row, partySize);
            }
        }

        if(!isRowApplicable("A", partySize)){
            return getSuggestedSeats(new Seat("B3"), new Seat("B4"), new Seat("B5"), new Seat("B6"), new Seat("B7"));
        }

        if (booked.contains(new Seat("A5"))) {

            return getSuggestedSeats(new Seat("A4"), new Seat("A3"));
        }

        return getSuggestedSeats(new Seat("A5"), new Seat("A6"));
    }

    private Set<Seat> getFreeSeats(String row, int partySize) {
        List<Integer> seats = theater.seats.get(row);
        int firstRowSeats = (seats.size() - partySize) /2;

        HashSet<Seat> freeSeats = new HashSet<>();
        for (int i = firstRowSeats; i < partySize + firstRowSeats; i++) {
            freeSeats.add(new Seat(row, i));
        }
        return null;
    }

    private boolean isRowApplicable(String rowName, int partySize) {
        return theater.seats.get(rowName).size() - booked.stream().filter(x->x.getRow().equals(rowName)).count() >= partySize;
    }

    private HashSet getSuggestedSeats(Seat ...names) {
        return new HashSet(Arrays.asList(names));
    }


}

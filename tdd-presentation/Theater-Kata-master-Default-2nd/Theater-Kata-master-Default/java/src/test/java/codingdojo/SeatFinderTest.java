package codingdojo;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class SeatFinderTest {

    @Test
    public void findTwoSeatsOnFrontRow() {
        Theater theater = Theater.standardTheater();
        List<Seat> booked = Arrays.asList(new Seat[] {new Seat("B2"), new Seat("B3"),
                new Seat("B4"), new Seat("B5")});
        SeatFinder seatFinder = new SeatFinder(theater, booked);
        assertEquals(new HashSet(Arrays.asList(new Seat[] {new Seat("A5"), new Seat("A6")})),
                seatFinder.suggest(2));
    }

    @Test
    public void findTwoSeatsOnFrontRowToTheRightWhenMiddleSeatsAreReserved() {
        // GIVEN
        Theater theater = Theater.standardTheater();
        List<Seat> booked = Arrays.asList(new Seat[] {new Seat("A5"), new Seat("A6")});
        SeatFinder seatFinder = new SeatFinder(theater, booked);

        // WHEN
        Set<Seat> suggeested = seatFinder.suggest(2);

        // THEN
        assertEquals(new HashSet(Arrays.asList(new Seat[] {new Seat("A7"), new Seat("A8")})),
                suggeested);
    }

    @Test
    public void findTwoSeatsOnFrontRowToTheLeftWhenMiddleSeatsAreReserved() {
        // GIVEN
        Theater theater = Theater.standardTheater();
        List<Seat> booked = Arrays.asList(new Seat[] {new Seat("A5"), new Seat("A6"),
                new Seat("A7"), new Seat("A8")});
        SeatFinder seatFinder = new SeatFinder(theater, booked);

        // WHEN
        Set<Seat> suggeested = seatFinder.suggest(2);

        // THEN
        assertEquals(wrapSeatNames("A3", "A4"), suggeested);
    }

    @Test
    public void findTwoSeatsOnFrontRowWhenMoreMiddleSeatsAreReserved() {
        // GIVEN
        Theater theater = Theater.standardTheater();
        List<Seat> booked = Arrays.asList(new Seat[] {new Seat("A7"), new Seat("A8"),
                new Seat("A5"), new Seat("A6"), new Seat("A4"), new Seat("A3")});
        SeatFinder seatFinder = new SeatFinder(theater, booked);

        // WHEN
        Set<Seat> suggeested = seatFinder.suggest(5);

        // THEN
        assertEquals(
                new HashSet(Arrays.asList(new Seat[] {new Seat("B3"), new Seat("B4"),
                        new Seat("B5"), new Seat("B6"), new Seat("B7")})), suggeested);
    }

    @Test
    public void findTwoSeatsOnSecondRowWhenNoFreeInFirst() {
        // GIVEN
        Theater theater = Theater.standardTheater();
        List<Seat> booked = Arrays.asList(new Seat[] {new Seat("A1"), new Seat("A2"),
                new Seat("A3"), new Seat("A4"), new Seat("A5"), new Seat("A6"), new Seat("A7"),
                new Seat("A8"), new Seat("A9"), new Seat("A10")});
        SeatFinder seatFinder = new SeatFinder(theater, booked);

        // WHEN
        Set<Seat> suggeested = seatFinder.suggest(2);

        // THEN
        assertEquals(wrapSeatNames("B5", "B6"), suggeested);
    }

    @Test
    public void findThreeSeatsOnFrontRowToTheLeftWhenMiddleSeatsAreReserved() {
        // GIVEN
        Theater theater = Theater.standardTheater();
        List<Seat> booked = Arrays.asList(new Seat[] {new Seat("A5"), new Seat("A6"),
                new Seat("A7")});
        SeatFinder seatFinder = new SeatFinder(theater, booked);

        // WHEN
        Set<Seat> suggeested = seatFinder.suggest(3);

        // THEN
        assertEquals(wrapSeatNames("A2", "A3", "A4"), suggeested);
    }

    public Set wrapSeatNames(String... names) {
        return Arrays.stream(names).map(name -> new Seat(name)).collect(Collectors.toSet());

    }
}

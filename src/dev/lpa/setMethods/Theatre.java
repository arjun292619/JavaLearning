package dev.lpa.setMethods;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {
    class Seat implements Comparable<Seat> {
        private String seatNum;
        private boolean isReserved;

        public Seat(char rowChar, int seatNum) {
            this.seatNum = "%c%03d".formatted(rowChar, seatNum).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Seat seat = (Seat) o;

            return seatNum.equals(seat.seatNum);
        }

        @Override
        public int hashCode() {
            return seatNum.hashCode();
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }

    private String theatreName;
    private int seatsPerRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows, int totalSeats) {
        this.theatreName = theatreName;
        this.seatsPerRow = totalSeats / rows;
        seats = new TreeSet<>();
        for (int i = 0; i < totalSeats; i++) {
            char rowChar = (char) (i / seatsPerRow + (int) 'A');
            int seatNo = i % seatsPerRow + 1;
            seats.add(new Seat(rowChar, seatNo));
        }
    }

    public void printSeatMap() {
        String lineSeparator = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map %n%1$s%n", lineSeparator, theatreName);
        int index = 0;
        for (Seat seat : seats) {
            System.out.printf("%-8s %s", seat.seatNum + ((seat.isReserved ? "(\u25CF)" : "")), (index++ + 1) % seatsPerRow == 0 ? "\n" : "");
        }
        System.out.println(lineSeparator);
    }

    public String reserveSeat(char row, int seat) {
        Seat requestedSeat = new Seat(row, seat);
        Seat matchedSeat = seats.floor(requestedSeat);
        if (matchedSeat == null || !matchedSeat.seatNum.equals(requestedSeat.seatNum)) {
            System.out.print("---> No such seat: " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n", seats.first().seatNum, seats.last().seatNum);
        } else {
            if (!matchedSeat.isReserved) {
                matchedSeat.isReserved = true;
                return matchedSeat.seatNum;
            } else {
                System.out.println("Seat is already reserved");
            }
        }
        return null;
    }
}

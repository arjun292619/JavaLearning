package dev.lpa.setMethods;


public class BookingAgent {
    public static void main(String[] args) {
        int rows = 10;
        int totalSeats = 100;

        Theatre belasco = new Theatre("Belasco", rows, totalSeats);

        belasco.printSeatMap();
        reserveSeat(belasco,'A',3);
    }

    private static void reserveSeat(Theatre theatre, char row, int seat) {
        String reserve = theatre.reserveSeat(row, seat);
        if (reserve != null) {
            System.out.println("Your seat is reserved " + reserve);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry unable to reserve the requested seat" + row + seat);
        }
    }
}

package buildings.office;

public class Office {
    private double square;
    private int numberRooms;


    private final double SQUARE = 250;
    private final int NUMBER_ROOMS = 1;

    public Office() {
        square= SQUARE;
        numberRooms=NUMBER_ROOMS;
    }

    public Office(double square) {
        this.square = square;
        numberRooms=NUMBER_ROOMS;
    }

    public Office(double square, int numberRooms) {
        this.square = square;
        this.numberRooms = numberRooms;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }
}

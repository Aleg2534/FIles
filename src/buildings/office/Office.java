package buildings.office;

import buildings.interfaces.Space;
import exceptions.InvalidRoomsCountExceptions;

public class Office implements Space {
    private double square;
    private int numberRooms;


    private final double SQUARE = 250;
    private final int NUMBER_ROOMS = 1;

    public Office() {
        square = SQUARE;
        numberRooms = NUMBER_ROOMS;
    }

    public Office(double square) {
        this.square = square;
        numberRooms = NUMBER_ROOMS;
    }

    public Office(double square, int numberRooms) throws InvalidRoomsCountExceptions {
        if (numberRooms > 7 || numberRooms < 0) {
            throw new InvalidRoomsCountExceptions(numberRooms);
        }
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

    public void setNumberRooms(int numberRooms) throws InvalidRoomsCountExceptions {
        if (numberRooms > 7 || numberRooms < 0) {
            throw new InvalidRoomsCountExceptions(numberRooms);
        }
        this.numberRooms = numberRooms;
    }

    @Override
    public String toString() {
        return "Office(" + numberRooms + ", " + square + ")";
    }

    @Override
    public Object clone() {
        return new Office(square, numberRooms);
    }

    @Override
    public int hashCode()
    {
        return (int) (getNumberRooms()+getSquare())*2;
    }
}

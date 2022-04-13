package buildings.dwelling;

import buildings.interfaces.Space;
import exceptions.InvalidRoomsCountExceptions;

public class Flat implements Space {
  private double square;
  private int numberRooms;


  private final double SQUARE = 50;
  private final int NUMBER_ROOMS = 2;

    public Flat() {
        square= SQUARE;
        numberRooms=NUMBER_ROOMS;
    }

    public Flat(double square) {
        this.square = square;
        numberRooms=NUMBER_ROOMS;
    }

    public Flat(double square, int numberRooms) throws InvalidRoomsCountExceptions {
        if(numberRooms>7 || numberRooms<0)
        {
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

    public void setNumberRooms(int numberRooms) throws InvalidRoomsCountExceptions{
        if(numberRooms>7 || numberRooms<0)
        {
            throw new InvalidRoomsCountExceptions(numberRooms);
        }
        this.numberRooms = numberRooms;
    }
}